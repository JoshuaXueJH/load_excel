package com.joshua.forRandomTest;

import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.bc.*;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;

public class GPGUtil {
    public void decryptFile(InputStream in, InputStream secKeyIn, InputStream pubKeyIn, char[] pass, String outputDir, String str)
            throws IOException, PGPException, InvalidCipherTextException {
        Security.addProvider(new BouncyCastleProvider());

        PGPPublicKey pubKey = readPublicKeyFromCol(pubKeyIn);

        PGPSecretKey secKey = readSecretKeyFromCol(secKeyIn, pubKey.getKeyID());

        in = PGPUtil.getDecoderStream(in);

        JcaPGPObjectFactory pgpFact;


        PGPObjectFactory pgpF = new PGPObjectFactory(in, new BcKeyFingerprintCalculator());

        Object o = pgpF.nextObject();
        PGPEncryptedDataList encList;

        if (o instanceof PGPEncryptedDataList) {

            encList = (PGPEncryptedDataList) o;

        } else {

            encList = (PGPEncryptedDataList) pgpF.nextObject();

        }

        Iterator<PGPPublicKeyEncryptedData> itt = encList.getEncryptedDataObjects();
        PGPPrivateKey sKey = null;
        PGPPublicKeyEncryptedData encP = null;
        while (sKey == null && itt.hasNext()) {
            encP = itt.next();
            secKey = readSecretKeyFromCol(new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(str)), encP.getKeyID());
            sKey = secKey.extractPrivateKey(new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider()).build(pass));
        }
        if (sKey == null) {
            throw new IllegalArgumentException("Secret key for message not found.");
        }

        InputStream clear = encP.getDataStream(new BcPublicKeyDataDecryptorFactory(sKey));

        pgpFact = new JcaPGPObjectFactory(clear);

        PGPCompressedData c1 = (PGPCompressedData) pgpFact.nextObject();

        pgpFact = new JcaPGPObjectFactory(c1.getDataStream());

        PGPLiteralData ld = (PGPLiteralData) pgpFact.nextObject();
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        InputStream inLd = ld.getDataStream();

        int ch;
        while ((ch = inLd.read()) >= 0) {
            bOut.write(ch);
        }

        bOut.writeTo(new FileOutputStream(String.join(File.separator, outputDir, ld.getFileName())));
    }

    public static void encryptFile(OutputStream out, String fileName, PGPPublicKey encKey) throws IOException, NoSuchProviderException, PGPException {
        Security.addProvider(new BouncyCastleProvider());

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(PGPCompressedData.ZIP);

        PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY, new File(fileName));

        comData.close();

        PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(new BcPGPDataEncryptorBuilder(SymmetricKeyAlgorithmTags.TRIPLE_DES).setSecureRandom(new SecureRandom()));

        cPk.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(encKey));

        byte[] bytes = bOut.toByteArray();

        OutputStream cOut = cPk.open(out, bytes.length);

        cOut.write(bytes);

        cOut.close();

        out.close();
    }

    public static PGPSecretKey readSecretKeyFromCol(InputStream in, long keyId) throws IOException, PGPException {
        in = PGPUtil.getDecoderStream(in);
        PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(in, new BcKeyFingerprintCalculator());

        PGPSecretKey key = pgpSec.getSecretKey(keyId);

        if (key == null) {
            throw new IllegalArgumentException("Can't find encryption key in key ring.");
        }
        return key;
    }

    @SuppressWarnings("rawtypes")
    public static PGPPublicKey readPublicKeyFromCol(InputStream in) throws IOException, PGPException {
        in = PGPUtil.getDecoderStream(in);
        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in, new BcKeyFingerprintCalculator());
        PGPPublicKey key = null;
        Iterator rIt = pgpPub.getKeyRings();
        while (key == null && rIt.hasNext()) {
            PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
            Iterator kIt = kRing.getPublicKeys();
            while (key == null && kIt.hasNext()) {
                PGPPublicKey k = (PGPPublicKey) kIt.next();
                if (k.isEncryptionKey()) {
                    key = k;
                }
            }
        }
        if (key == null) {
            throw new IllegalArgumentException("Can't find encryption key in key ring.");
        }
        return key;
    }
}

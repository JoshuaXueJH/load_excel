package com.joshua.forRandomTest;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Base64Encoder {
    public static void main(String[] args) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encode(Files.readAllBytes(new File("/Users/xuejianhua/Desktop/thailand/新合同模板/前端样本/email-model_3/font/kanit-regular/kanit-regular.woff.ttf").toPath()));
        System.out.println(base64);
    }
}

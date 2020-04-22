package com.joshua.forRandomTest;

import org.bouncycastle.openpgp.PGPPublicKey;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class gpgTest {
    public static void main(String[] args) throws FileNotFoundException {
        String pubKey = "LS0tLS1CRUdJTiBQR1AgUFVCTElDIEtFWSBCTE9DSy0tLS0tCgptUUVOQkY0Tm4yOEJDQUNxd015\n" +
                "NlliRE01WTRhKzdwUWxTTHVXOWQvNE1ZMlBrT0JPODlJMTdMOW9qSEdna3J0CisxOXFaUjl4NkVy\n" +
                "Mm1oZ2JFbmp2QjJTMUdsZzZnaHM4eUZrcUlIYUdsSWkrbGxRMGRWTXFNbjRiUjA3dUpVYUkKWDBB\n" +
                "a1FKeUR6bEwvYnViQ2k2dmtKSm5yU2FrUUFQUUtRMWJERGdudGprbCs1K21ZMEs4NWxPRjl2QXFG\n" +
                "cm02LwphWnQxMktCTUFlemFCa0pDNnVLUk0zU0R4cCtscEZ2MnJnZ1JQRUhEN05HVVZUZGdRSmZ0\n" +
                "RXhncWRzeEZPeVhqClFIUVVuRDNnaE9xQXhFZHRkeUtYemNDQUphWGNRalVqUjZNVDdQRmQ4eGxU\n" +
                "dHpWbysxUWJjYkdVY0RKNFZ0UFMKYm1obUJrbERIOEVkdThJMkhCK3B4di9WekRVUXpFTmVVdmo3\n" +
                "QUJFQkFBRzBLRTFQVGtsWVgxTkRRbDlWUVZRZwpQRzF2Ym1sNFgzTmpZbDkxWVhSQWJXOXVhWGd1\n" +
                "ZEdWamFENkpBVTRFRXdFS0FEZ1dJUVIyNmMrd1RBRnAyZHozCkkwRm5aRG9ZSDhMcGVBVUNYZzJm\n" +
                "YndJYkF3VUxDUWdIQWdZVkNna0lDd0lFRmdJREFRSWVBUUlYZ0FBS0NSQm4KWkRvWUg4THBlSlRo\n" +
                "Q0FDY0VONlhiSWZVNHd0dHR6cWh4SnlqVU1zbTY0SHBURUdDaGpqS3M1NDJGVXMyZkRKdQp2M0VL\n" +
                "OG5JY1ByNlMzVVdNY3R5YUpRZS9MWGFXUlFIRmxha0VlZU9oVGhHV3JxRDFIaExWNVJyMTE3UWk1\n" +
                "bHJiCldVUkhLTFJDL3B6WEYvZHdtekJ3TmJPS2Y0VDVlQ2Z2MWwxK2ZpNy9Dem83Vkl5WU43T0h4\n" +
                "TG1HM01JWHNJR08KVzFpc0tMcmJKbU9EOEw0aWdKRTkxYnAwTlhoQU9aTU5JS1E4cHZ4cERHY2N4\n" +
                "VHFib3I0U1A4QThGdTZobDB1eQp4SVp1V3o0TkVNZGhKa0JkRk0wRVpxT0ZKOTExQ1V0cUdKVnBy\n" +
                "UHlIMXZLb3RDWi9WM1JHM2ltVXJEUENSaTFnCjdwZ2JNdnR2MXJSRTJMZVh3YzJ6WmtuYi9LQWs5\n" +
                "czBDUzZTZXVRRU5CRjRObjI4QkNBRFY5YW1nU3Q0Q1lGNHYKNlRlbSt1UVVmNzhMYjM1VkEzWlRv\n" +
                "NXMyS0d6YUFmNVZIbnNqNllYbDVrU25VRE9sZlh4Q3hzNjg5dmRoYUd4Ngp3VUNBMzFVdHh6bDVa\n" +
                "b3lYdEx3aGI1aE5VMUlvZjJPak9ackZ2Y0JjS1JOVHhlVWc1dDZUQVpqUFhydTdJeDNNCnNsK2dP\n" +
                "UTI4Ykp2Y2pDYWN4WHJmSjIwMjF4ZDVrZW1jYzZ4RW5DT0JmcW1RR2dXRnA4ZXVEbGNaNXBXenlT\n" +
                "a1kKNmZSUmYwK3p3cVJiZi9hV0N3VGhMMmpvK3BadDB4MWJaTDlsWGJSSndVcFM3L2VvZm83NVNL\n" +
                "ZmUwVENsd2xRVgpFV0VGWW5sM0gzSFI3NENDN3pVems4RjVrNW5mVmVYN3VRTHFGMTczTzYxcXNk\n" +
                "enJROUJjQzJoejQveFdFeGFxCnlWOWRZdG50QUJFQkFBR0pBVFlFR0FFS0FDQVdJUVIyNmMrd1RB\n" +
                "RnAyZHozSTBGblpEb1lIOExwZUFVQ1hnMmYKYndJYkRBQUtDUkJuWkRvWUg4THBlR2FGQi80eENS\n" +
                "elpwR3Vkbloyd3B2eDZ3d3g5YUN3YThpQ0QvaVZ2SHNPaQowelpZQno2aytQNkJSRUtsejJ0em82\n" +
                "UFhYQXo0SUlKRVZGUXhZdG55ODQ3OThqVHFHdld6ZUJCR3NLcVZOb2FaClRyZ25IR2JtL3RHMlVR\n" +
                "U3NXSWh2SFIycnNpYTBGNlk0dWNHbTE3QkJkazZlZzBxbW85bjkwb2UxaXpXTmJDMVgKY3lxRks4\n" +
                "SXBsZnVsWHNZZEdyOEw0ZjV5R2dzWDV1NmttWm44cWpLblB0L2hIZkhoZW1Lby9iSlY2dndDRkdD\n" +
                "NQpJbU1tbURFaVhHQ0lQK1Y4YnpWNU96OWRJYmNEenA4OTBLUnM5RDZ0MCtkM0p2enc5Y0ZtZ0Vr\n" +
                "TFAzbTA2RUZECnBpT1AwZ0hwL05rQlVWS1dIZGp0ZEs0VlpZN1ZJWTNVNVM2QmM0V2JIKzFacWE5\n" +
                "MQo9b3cwTwotLS0tLUVORCBQR1AgUFVCTElDIEtFWSBCTE9DSy0tLS0tCg==";
        String secKey = "LS0tLS1CRUdJTiBQR1AgUFJJVkFURSBLRVkgQkxPQ0stLS0tLQoKbFFPWUJGNE5uMjhCQ0FDcXdN\n" +
                "eTZZYkRNNVk0YSs3cFFsU0x1VzlkLzRNWTJQa09CTzg5STE3TDlvakhHZ2tydAorMTlxWlI5eDZF\n" +
                "cjJtaGdiRW5qdkIyUzFHbGc2Z2hzOHlGa3FJSGFHbElpK2xsUTBkVk1xTW40YlIwN3VKVWFJClgw\n" +
                "QWtRSnlEemxML2J1YkNpNnZrSkpuclNha1FBUFFLUTFiRERnbnRqa2wrNSttWTBLODVsT0Y5dkFx\n" +
                "RnJtNi8KYVp0MTJLQk1BZXphQmtKQzZ1S1JNM1NEeHArbHBGdjJyZ2dSUEVIRDdOR1VWVGRnUUpm\n" +
                "dEV4Z3Fkc3hGT3lYagpRSFFVbkQzZ2hPcUF4RWR0ZHlLWHpjQ0FKYVhjUWpValI2TVQ3UEZkOHhs\n" +
                "VHR6Vm8rMVFiY2JHVWNESjRWdFBTCmJtaG1Ca2xESDhFZHU4STJIQitweHYvVnpEVVF6RU5lVXZq\n" +
                "N0FCRUJBQUVBQi93T2JaZDBVWmcxM1ZrWG0wT2wKVnM5ZnpWbzFPbEg2b3JlT0xrdnRQMjlSWjlO\n" +
                "d09ad3o1YlNzbkhvcFpDa2V2ZXMyMjdzUGxOUUQ5WU9WQUxTNgpleGRiQVpQaVQvUzBzMUVrS1p4\n" +
                "ckNWOHgxamNBMVJ6VG5jWWhYMldhUVk4dWVZN1N5MzNYeGp2M1JLbkl2MmFLCk9NeHJxT2tGTGdF\n" +
                "SjBjdDI3U2lST0t6Mlh3K0ZnOFcyREE4cDQ3TUU2b0Z4MVBwcHB3alYxSndzNVRBbFhMNTIKSFQ4\n" +
                "RGdaWTduY1pab3dNZ3U2V0VFWi9keTI3S00xakxqc3NaWmtMNkhkaTN4d0cvN2c0WEVWeG0yZDFN\n" +
                "bjZYMgpZMHpzZDBYN3JmekxZY2NRcUJyV1FvUXdtTTZZdGlPdC9yVDNXRXdtNDFnbEE3S01vWkVC\n" +
                "TC9rODEzc2tJSHlNClM4dnhCQURGMmgyeWY3SzBSZDZzWGJtN1Z3TjR1WlNkd2xySUpTK0lOZVlm\n" +
                "bEJWT0dFTm9NOXBuTFk5UjJNZHYKSjJhT0p2bzAzMVlkcVlqTkw1YjJwVUZqZ3o3dzJOanpURDdD\n" +
                "eXZpUzFKSlVwc05pcGFjMjF3RytNMkhyV245NwoyM29sS1RyMWtDVDhFTW94M2pCUEh1czZWamph\n" +
                "QVZKYU1oWXgzQzI5L2l6SnpUNTNTUVFBM08vVThYdG9FcmpSCjlDWWVHOFRDZE1rRkNaeElRUXlJ\n" +
                "Vjdja0ZoRm13emJnSlJkaUtYWXlYRUcxZmVoMllKYXVVbkVIak1TYm4wM2QKeS91NUFLTEZXekRo\n" +
                "Wm94aG9sMTN0aW9kVWRweEJYL3dKMVlzTnRYQlJrNndFMi9RSENPWmY5WjhZRjh6elRnSQpXK2dw\n" +
                "YWlXbjhPMmkrS3R2NlJMZmVxYUd1Z1VSV2lNRC8yWXJ1ZytwUENwRXpPNUxLVjRHWDlqWU9QNU50\n" +
                "TmhZCjhuZmFxV2I1aDYwd1BYWDJzcmN1MGpsbmZXb29uczlKQ1Mwelg5aUF4WnZQQVM1Q0lXdWw1\n" +
                "VUkwMVNuODhJQTUKT3FnZjQ1NjRvQ284R0taSjBja0xBOC9STVZYQVY3WVpyTE9DUElxT2RzMGN1\n" +
                "QVdMeFlBSTB1bnd0M0FKYkI2dQp6RzRJbEw1TW9vWjdPaVMwS0UxUFRrbFlYMU5EUWw5VlFWUWdQ\n" +
                "RzF2Ym1sNFgzTmpZbDkxWVhSQWJXOXVhWGd1CmRHVmphRDZKQVU0RUV3RUtBRGdXSVFSMjZjK3dU\n" +
                "QUZwMmR6M0kwRm5aRG9ZSDhMcGVBVUNYZzJmYndJYkF3VUwKQ1FnSEFnWVZDZ2tJQ3dJRUZnSURB\n" +
                "UUllQVFJWGdBQUtDUkJuWkRvWUg4THBlSlRoQ0FDY0VONlhiSWZVNHd0dAp0enFoeEp5alVNc202\n" +
                "NEhwVEVHQ2hqaktzNTQyRlVzMmZESnV2M0VLOG5JY1ByNlMzVVdNY3R5YUpRZS9MWGFXClJRSEZs\n" +
                "YWtFZWVPaFRoR1dycUQxSGhMVjVScjExN1FpNWxyYldVUkhLTFJDL3B6WEYvZHdtekJ3TmJPS2Y0\n" +
                "VDUKZUNmdjFsMStmaTcvQ3pvN1ZJeVlON09IeExtRzNNSVhzSUdPVzFpc0tMcmJKbU9EOEw0aWdK\n" +
                "RTkxYnAwTlhoQQpPWk1OSUtROHB2eHBER2NjeFRxYm9yNFNQOEE4RnU2aGwwdXl4SVp1V3o0TkVN\n" +
                "ZGhKa0JkRk0wRVpxT0ZKOTExCkNVdHFHSlZwclB5SDF2S290Q1ovVjNSRzNpbVVyRFBDUmkxZzdw\n" +
                "Z2JNdnR2MXJSRTJMZVh3YzJ6WmtuYi9LQWsKOXMwQ1M2U2VuUU9ZQkY0Tm4yOEJDQURWOWFtZ1N0\n" +
                "NENZRjR2NlRlbSt1UVVmNzhMYjM1VkEzWlRvNXMyS0d6YQpBZjVWSG5zajZZWGw1a1NuVURPbGZY\n" +
                "eEN4czY4OXZkaGFHeDZ3VUNBMzFVdHh6bDVab3lYdEx3aGI1aE5VMUlvCmYyT2pPWnJGdmNCY0tS\n" +
                "TlR4ZVVnNXQ2VEFaalBYcnU3SXgzTXNsK2dPUTI4Ykp2Y2pDYWN4WHJmSjIwMjF4ZDUKa2VtY2M2\n" +
                "eEVuQ09CZnFtUUdnV0ZwOGV1RGxjWjVwV3p5U2tZNmZSUmYwK3p3cVJiZi9hV0N3VGhMMmpvK3Ba\n" +
                "dAoweDFiWkw5bFhiUkp3VXBTNy9lb2ZvNzVTS2ZlMFRDbHdsUVZFV0VGWW5sM0gzSFI3NENDN3pV\n" +
                "ems4RjVrNW5mClZlWDd1UUxxRjE3M082MXFzZHpyUTlCY0MyaHo0L3hXRXhhcXlWOWRZdG50QUJF\n" +
                "QkFBRUFCL3dLb2ltdFozaDIKcGtXYXZIZG1yZi9tc1QyZkFCOXlIVml2WDBsd0ROekhZME41ci80\n" +
                "MGpVbk90Zk1TQjFIMXh0R0ZrUk5id0FDNwpQNEVWV0dRNnMybHNrUmcvRUw5cWdtYzZMZGdPenhZ\n" +
                "SUlMZjU0cVpFUkd5dnQ5Nk5IVFZJdldpYmtPcXJDRjBzCm9sb1JYd2tTY2JESUovUUJaMFFRLzdN\n" +
                "enJYdUhvWjRrb3IrZG5aL0ZZeGpJdER5QnIvTHhQRlpXMWxtV3BNT2gKQWpFK1pCVVVOMWNNMWtZ\n" +
                "MTl6MWFHcUkrcEN1anQ3dWV3TDVUdzJzRWUrUzhKN1FFQi90cnIzbFBDMzZLTHEvSwpVVHRhNnRq\n" +
                "WGE1MEZUc2xESFp1cDJ5WkMwQmRnWHlSRHNIRXNNL1IrZGhQOXU2VVZuc0o2Q3EybEwwWjhTWk1i\n" +
                "ClcrdUtETk91VTY5eEJBRGl4QWxFRGZlaG5IUkYvbFhsTkhsV1c2ZkpqT1docG13NnJYbzBsVE9W\n" +
                "MWFRdDJETEwKcThtcDhMWXIrTnBSNDJRcVlSbkExSzVJZEZoWVJtQmszUUV0VjBvTlZvTXlBYkVt\n" +
                "cnNjdDY1TVBlYWhJWUdvTQpaV2RNYjAvMnBPZStNRXBKdVZVOHR4K3lveUlzdS9hRm5XUGJFNU9r\n" +
                "RU9YTFpORG1wWWlKVUo0OWNRUUE4WXI4CkFXdHBieVVrWTJlMDVPMnNrc2NjTmpDUWdydGFnNmFr\n" +
                "RjB2ZUtuSDlGTTJvc2piS2lKcFBpOFIwalBHVDQvSUEKVVVCWWN0R0gzNXNoajB3Vmt0akNrVnls\n" +
                "TnQ3dmFadGhSSFRjNTUyTlNCNFJLbWdMRjlTRGNSYUNQakdBYmswSAptL1dUcXVjRHdIOFBzZmdy\n" +
                "MThSbzhDUWkxU28ydHJhb3lJdU9sajBEK3dUeVIvV1FxcXkxaG03ekgxc09WZUozClVGSlNPb1ZV\n" +
                "WFVGNUxPZG5uQWJHMytjcHFmTW5WVnBhK09WYUtNSEk2bC8wUzJ4M0VhbnRwejVQN3lKOHVqYm4K\n" +
                "TkplamZrUjZIV0xTbyt5ZmxyTUJPKzBjTFpHVk5DRFh6bG9JNTVVVlNMMExyaDJsT0phZi8zaG9C\n" +
                "R0Q2U1E5bQpoZFl4NExZN1NIYU9RYjN5T2x6RU41Q0pBVFlFR0FFS0FDQVdJUVIyNmMrd1RBRnAy\n" +
                "ZHozSTBGblpEb1lIOExwCmVBVUNYZzJmYndJYkRBQUtDUkJuWkRvWUg4THBlR2FGQi80eENSelpw\n" +
                "R3Vkbloyd3B2eDZ3d3g5YUN3YThpQ0QKL2lWdkhzT2kwelpZQno2aytQNkJSRUtsejJ0em82UFhY\n" +
                "QXo0SUlKRVZGUXhZdG55ODQ3OThqVHFHdld6ZUJCRwpzS3FWTm9hWlRyZ25IR2JtL3RHMlVRU3NX\n" +
                "SWh2SFIycnNpYTBGNlk0dWNHbTE3QkJkazZlZzBxbW85bjkwb2UxCml6V05iQzFYY3lxRks4SXBs\n" +
                "ZnVsWHNZZEdyOEw0ZjV5R2dzWDV1NmttWm44cWpLblB0L2hIZkhoZW1Lby9iSlYKNnZ3Q0ZHQzVJ\n" +
                "bU1tbURFaVhHQ0lQK1Y4YnpWNU96OWRJYmNEenA4OTBLUnM5RDZ0MCtkM0p2enc5Y0ZtZ0VrTApQ\n" +
                "M20wNkVGRHBpT1AwZ0hwL05rQlVWS1dIZGp0ZEs0VlpZN1ZJWTNVNVM2QmM0V2JIKzFacWE5MQo9\n" +
                "emIzawotLS0tLUVORCBQR1AgUFJJVkFURSBLRVkgQkxPQ0stLS0tLQo=";
        GPGUtil util = new GPGUtil();
        try {
            util.decryptFile(new FileInputStream("/Users/xuejianhua/Desktop/monix_test_temp/gpgtest/SCB_MONIX_4680936049_20200305_092504_D.gpg"),
                    new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(secKey)),
                    new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(pubKey)),
                    "".toCharArray(), "/Users/xuejianhua/Desktop/monix_test_temp/gpgtest", secKey);

/*            PGPPublicKey pubKey = util.readPublicKeyFromCol(new FileInputStream("/Users/xuejianhua/Desktop/monix_test_temp/gpgtest/pubKey_uat.asc"));

            util.encryptFile(new FileOutputStream("/Users/xuejianhua/Desktop/monix_test_temp/gpgtest/SCB_MONIX_4680936049_20200310_033200_D.gpg"),
                    "/Users/xuejianhua/Desktop/monix_test_temp/gpgtest/SCB_MONIX_4680936049_20200310_033200_D", pubKey);*/
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

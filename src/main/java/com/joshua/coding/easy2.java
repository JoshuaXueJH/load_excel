package com.joshua.coding;

import java.util.Arrays;
import java.util.List;

public class easy2 {
    /**
     * transform an array of bytes to hex coding.
     * Given arr = [0xEF, 0x07, 0x03, 0x47]
     * return "EF070347"
     * class definition:
     * <p>
     * class Solution {
     * <p>
     * public String  hexCoding(List<Byte> arr) {
     * <p>
     * <p>
     * <p>
     * }
     * <p>
     * }
     */

    private static char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        Byte[] bytes = {0x2F, 0x07, 0x03, 0x47, -98};
        String res = hexCoding3(Arrays.asList(bytes));
        System.out.println(res);
    }

    public static String hexCoding(List<Byte> bytes) {


        char[] buf = new char[bytes.size() * 2];
        int a = 0;
        int index = 0;
        for (byte b : bytes) {
            if (b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }

        return new String(buf);
    }

    public static String hexCoding2(List<Byte> bytes) {
        char[] buf = new char[bytes.size() * 2];
        int index = 0;
        for (byte b : bytes) {
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }
        return new String(buf);
    }

    public static String hexCoding3(List<Byte> bytes) {
        StringBuilder buf = new StringBuilder(bytes.size() * 2);
        for (byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }
}

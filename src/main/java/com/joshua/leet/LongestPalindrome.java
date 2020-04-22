package com.joshua.leet;

import java.util.Stack;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s))
            return "";

        int len = s.length();
        int i, j;
        while (len > 1) {
            for (i = 0, j = len - 1; i < s.length() && j < s.length(); i++, j++) {
                String subStr = cutStr(s, i, j);
                if (isPalindrome(subStr))
                    return subStr;
            }
            len--;
        }
        return s.substring(0, 1);
    }

    public String longestPalindrome1(String s) {
        if (s == null || "".equals(s))
            return "";

        int length = s.length();
        boolean[][] b = new boolean[length][length];
        int len = 1;
        int maxL = 0;
        String maxP = "";

        while (len <= length) {
            for (int i = 0, j = i + len - 1; i < length && j < length; i++, j++) {
                b[i][j] = (len == 1 || (len == 2 && s.charAt(i) == s.charAt(j)) || (b[i + 1][j - 1] && s.charAt(i) == s.charAt(j)));
                if (b[i][j]) {
                    if (j - i + 1 > maxL) {
                        maxL = j - i + 1;
                        maxP = s.substring(i, j + 1);
                    }
                }
            }
            len++;
        }
        return maxP;
    }

    public String cutStr(String s, int i, int j) {
        if (s == null || "".equals(s))
            return "";

        return s.substring(i, j + 1);
    }

    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s))
            return false;

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome o = new LongestPalindrome();
        String str = o.longestPalindrome1("b");
        System.out.println(str);
    }
}

package com.joshua;

public class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        System.out.println(instance.longestPanlindrom("xaaabbaaabe"));
    }

    public String longestPanlindrom(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        boolean[][] matrix = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String maxStr = "";


        int len = 1;
        while (len <= s.length()) {
            for (int i = 0, j = i + len - 1; i < s.length() && j < s.length(); i++, j++) {
                if (len == 1) {
                    matrix[i][j] = true;
                } else if (len == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        matrix[i][j] = true;
                    }
                } else {
                    if (matrix[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        matrix[i][j] = true;
                    }
                }
                if (matrix[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStr = s.substring(i, j + 1);
                    }
                }
            }
            len++;
        }

        return maxStr;
    }
}

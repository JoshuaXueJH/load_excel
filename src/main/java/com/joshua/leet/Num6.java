package com.joshua.leet;

import java.util.*;

public class Num6 {
    public static void main(String[] args) {
        Num6 instance = new Num6();
        System.out.println(instance.convert("LEETCODEISHIRING", 4));
    }
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows < 2) {
            return s;
        }

        int len = s.length();
        int depth = numRows;
        int blockSum = depth + depth - 2;
        int blockNum = len / blockSum;
        int width1 = blockNum * (1 + depth - 2);
        int width2 = len - blockNum * blockSum;
        int width = width1 + width2;
        Character[][] grid = new Character[depth][width];

        int row = 0, col = 0;
        int p = 0;
        boolean downwards = true;

        while (p < len) {
            if (downwards) {
                if (row < depth) {
                    grid[row][col] = s.charAt(p);
                    row++;
                    p++;
                } else {
                    row--;
                    downwards = false;
                }
            } else {
                if (row > 1) {
                    row--;
                    col++;
                    grid[row][col] = s.charAt(p);
                    p++;
                } else {
                    downwards = true;
                    col++;
                    row--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < depth; j++) {
                if (grid[i][j] != null) {
                    sb.append(grid[i][j]);
                }
            }
        }
        return sb.toString();
    }
}

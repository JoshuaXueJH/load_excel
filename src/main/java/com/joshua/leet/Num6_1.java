package com.joshua.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Num6_1 {
    public static void main(String[] args) {
        Num6_1 instance = new Num6_1();
        System.out.println(instance.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows < 2) {
            return s;
        }

        int len = s.length();
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, len); i++) {
            list.add(new StringBuilder());
        }

        int currRow = 0;
        boolean downwards = false;

        for (char c : s.toCharArray()) {
            list.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                downwards = !downwards;
            }
            currRow += downwards ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        list.forEach(sb -> res.append(sb));
        return res.toString();
    }
}

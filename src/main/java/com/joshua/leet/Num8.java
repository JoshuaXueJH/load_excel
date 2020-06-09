package com.joshua.leet;

public class Num8 {
    public static void main(String[] args) {
        Num8 instance = new Num8();
        System.out.println(instance.myAtoi1("   -42"));
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if (c == '-' || c == '+' || (c >= 48 && c <= 57)) {
                    sb.append(c);
                } else {
                    return 0;
                }
                continue;
            }

            if (c >= 48 && c <= 57) {
                sb.append(c);
            } else {
                break;
            }
        }

        str = sb.toString();
        if (str.equals("-") || str.equals("+") || str.isEmpty()) {
            return 0;
        }
        Double val = Double.parseDouble(str);
        if (val.compareTo((double) Integer.MIN_VALUE) < 0) {
            return Integer.MIN_VALUE;
        }
        if (val.compareTo((double) Integer.MAX_VALUE) > 0) {
            return Integer.MAX_VALUE;
        }
        return val.intValue();
    }

    public int myAtoi1(String str) {
        if (str == null || (str = str.trim()).isEmpty()) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if (c == '-' || c == '+' || (c >= 48 && c <= 57)) {
                    sb.append(c);
                } else {
                    return 0;
                }
                continue;
            }
            if (c >= 48 && c <= 57) {
                sb.append(c);
            } else {
                break;
            }
        }

        str = sb.toString();
        if (str.isEmpty() || str.equals("-") || str.equals("+")) {
            return 0;
        }

        int res = 0;
        boolean flag = true;
        int p = 0;
        if (str.charAt(0) == '-') {
            flag = false;
            p++;
        }
        if (str.charAt(0) == '+') {
            p++;
        }
        while (p < str.length()) {
            int temp = str.charAt(p) - '0';
            if (flag && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp >= 7))) {
                return Integer.MAX_VALUE;
            }
            if (!flag && (res > Math.abs(Integer.MIN_VALUE / 10) || (-res == Integer.MIN_VALUE / 10 && temp >= 8))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + temp;
            p++;
        }
        return flag ? res : -res;
    }
}

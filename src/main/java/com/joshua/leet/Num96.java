package com.joshua.leet;

public class Num96 {
    public static void main(String[] args) {
        Num96 instance = new Num96();
        System.out.println(instance.numTrees(3));
    }

    public int numTrees(int n) {
        int[] stock = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                stock[i] = 1;
                continue;
            }
            int currNum = 0;
            for (int j = 0, k = i - j - 1; j < i && k >= 0; j++, k--) {
                currNum = currNum + stock[j] * stock[k];
            }
            stock[i] = currNum;
        }

        return stock[n];
    }
}

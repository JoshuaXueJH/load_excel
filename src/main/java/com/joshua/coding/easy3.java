package com.joshua.coding;

import java.util.Arrays;
import java.util.List;

public class easy3 {
    /**
     * Write a function to find the longest common prefix among a list of strings.
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * <p>
     * Input: ["people","pen","put"]
     * Output: "p"
     * Example 2:
     * <p>
     * Input: ["apple","run","people"]
     * Output: ""
     * class definition:
     * <p>
     * class Solution {
     * <p>
     * public String  commonPrefix(List<String> arr) {
     * <p>
     * <p>
     * <p>
     * }
     * <p>
     * }
     */

    public static void main(String[] args) {
        String[] strs = {"p3eople", "p3en", "p33ut"};
        String commonPrefix = commonPrefix(Arrays.asList(strs));

        System.out.println(commonPrefix);

    }

    public static String commonPrefix(List<String> arrs) {
        if (arrs == null || arrs.size() == 0) {
            return "";
        }

        int maxCommonLength = shortestLength(arrs);
        while (maxCommonLength > 0) {
            boolean found = true;
            String model = arrs.get(0).substring(0, maxCommonLength);
            for (String arr : arrs) {
                if (!found) {
                    break;
                }
                if (!arr.substring(0, maxCommonLength).equals(model)) {
                    found = false;
                }
            }
            if (found)
                return model;
            maxCommonLength--;
        }
        return "";
    }

    public static int shortestLength(List<String> arrs) {
        int shortestLength = Integer.MAX_VALUE;
        for (String arr : arrs) {
            if (arr.length() < shortestLength)
                shortestLength = arr.length();
        }
        return shortestLength;
    }
}

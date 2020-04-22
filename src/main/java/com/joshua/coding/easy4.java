package com.joshua.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class easy4 {
    /**
     * remove an element from List.
     * Given an array nums and a value val, remove all instances of that value and return the new List. val can be any value.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array with O(1) extra memory.
     * <p>
     * <p>
     * <p>
     * Example :
     * <p>
     * Given nums = [3,2,7,2,3], val = 3,
     * return [2,7,2]
     * class definition:
     * <p>
     * class Solution {
     * <p>
     * public List<Integer> commonPrefix(List<Integer> arr, Integer Val) {
     * <p>
     * <p>
     * <p>
     * }
     * <p>
     * }
     */
    public static void main(String[] args) {
        Integer[] nums = {3, 2, 7, 2, 3};

        List<Integer> res = removeVal(new ArrayList<>(Arrays.asList(nums)), 3);
        res.forEach(item -> System.out.println(item));
    }

    public static List<Integer> removeVal(List<Integer> vals, Integer val) {
        for (int i = 0, length = vals.size(); i < length; i++) {
            if (vals.get(i) == val.intValue()) {
                vals.remove(i);
                length--;
                i--;
            }
        }
        return vals;
    }
}

package com.joshua.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class easy1 {
    /**
     * output the number pairs whose sum is a specific number:
     * Given an array of integers, return pairs of the two numbers such that they add up to a specific target. you may not use the same element twice within one pair.
     * Given nums = [2, 7, 2, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1],[1, 2]
     * class definition:
     * <p>
     * class Solution {
     * <p>
     * public List<List<Integer> > twoSum(List<Integer>nums, Integer target) {
     * <p>
     * <p>
     * <p>
     * }
     * <p>
     * }
     */

    public static void main(String[] args) {
        Integer[] integers = {2, 7, 2, 11, 15, 3, 15, 4, 14, 9, 9};
        List<List<Integer>> res = twoSum(Arrays.asList(integers), 18);

        res.forEach(line -> {
            line.forEach(item -> System.out.print(item + "  "));
            System.out.println();
        });
    }

    public static List<List<Integer>> twoSum(List<Integer> nums, Integer target) {
        if (nums == null || nums.size() == 0 || target == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    res.add(item);
                }
            }
        }

        return res;
    }
}

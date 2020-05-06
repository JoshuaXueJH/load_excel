package com.joshua.leet;

import java.util.HashSet;
import java.util.Set;

public class AddNum {

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        boolean carry = false;

        ListNode sum = res;
        while(l1 != null && l2 != null){
            int partialSum = l1.val + l2.val + (carry ? 1 : 0);
            carry = partialSum >= 10 ? true : false;
            sum.next = new ListNode(carry ? partialSum % 10 : partialSum);
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum.next = new ListNode(l1.val + (carry ? 1 : 0));
            sum = sum.next;
            carry = false;
        }
        while(l2 != null){
            sum.next = new ListNode(l2.val + (carry ? 1 : 0));
            sum = sum.next;
            carry = false;
        }
        return sum.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        int sum = l1.val + l2.val;
        boolean carry = sum >= 10;
        ListNode res = new ListNode(carry ? sum % 10 : sum);
        ListNode point = res;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l2.val;
                l2 = l2.next;
            }
            if (carry) {
                sum += 1;
                carry = false;
            }
            carry = sum >= 10;
            point.next = new ListNode(carry ? sum % 10 : sum);
            point = point.next;
        }
        if (carry) point.next = new ListNode(1);
        return res;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int sLen = s.length();
        int longest = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(i < sLen || j < sLen){
            if(j < sLen && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            } else {
                longest = Math.max(longest, set.size());
                j = ++i;
                set.clear();
            }
        }
        return longest;
    }
}

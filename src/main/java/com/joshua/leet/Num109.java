package com.joshua.leet;

public class Num109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next.next = new ListNode(9);


        Num109 instance = new Num109();
        TreeNode root = instance.sortedListToBST(head);
        System.out.println(root);
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        TreeNode root = new TreeNode(head.val);
        TreeNode p = root;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            p.right = new TreeNode(head.val);
            p = p.right;
            len++;
        }

        return balanceRight(root, len);
    }

    private TreeNode balanceRight(TreeNode root, int len) {
        if (len <= 1) {
            return root;
        }

        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            root.right.left = root;
            root = root.right;
            root.left.right = null;
        }
        root.left = balanceLeft(root.left, mid);
        root.right = balanceRight(root.right, len - mid - 1);
        return root;
    }

    private TreeNode balanceLeft(TreeNode root, int len) {
        if (len <= 1) {
            return root;
        }

        int mid = len / 2;
        for (int i = 0; i < mid - 1; i++) {
            root.left.right = root;
            root = root.left;
            root.right.left = null;
        }
        root.left = balanceLeft(root.left, mid);
        root.right = balanceRight(root.right, len - mid - 1);
        return root;
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            this.val = x;
        }
    }
}

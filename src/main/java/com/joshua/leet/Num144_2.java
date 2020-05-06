package com.joshua.leet;

import java.util.*;

public class Num144_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.left.right.left = new TreeNode(10);
        root.left.left.right.right = new TreeNode(11);
        root.left.left.right.left.left = new TreeNode(12);
        root.left.left.right.left.left.right = new TreeNode(13);
        root.left.left.right.left.left.right.left = new TreeNode(14);
        root.left.left.right.left.left.right.right = new TreeNode(15);

        Num144_2 o = new Num144_2();
        List<Integer> res = o.preorderTraversal(root);
        System.out.println(res);
    }

    private List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            res.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return res;
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

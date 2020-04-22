package com.joshua.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Num144 {
    private Stack<TreeNode> stack;

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
        root.left.left.right.left.left.right.left = new TreeNode(15);
        root.left.left.right.left.left.right.right = new TreeNode(14);

        Num144 o = new Num144();
        List<Integer> res = o.preorderTraversal(root);
        System.out.println(res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        stack = new Stack<>();
        TreeNode curr = root;

        List<Integer> res = new ArrayList<>();

        while (curr != null) {
            res.add(curr.val);

            if (curr.left != null) {
                stack.push(curr);
                curr = curr.left;
                continue;
            }
            if (curr.right != null) {
                curr = curr.right;
                continue;
            }
            if (stack.isEmpty()) return res;
            while (!stack.isEmpty()) {
                curr = stack.pop().right;
                if (curr != null) break;
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

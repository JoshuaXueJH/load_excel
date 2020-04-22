package com.joshua.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InOrderTraversaal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                inOrder.add(node.val);
                if (node.right != null) {
                    root = node.right;
                }
            }
        }
        return inOrder;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

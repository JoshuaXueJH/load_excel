package com.joshua.leet;

import java.util.Stack;

public class BSTIterator1 {
    private Stack<TreeNode> stack;
    private TreeNode curr;

    public BSTIterator1(TreeNode root) {
        if (root == null)
            return;

        stack = new Stack<>();
        curr = root;
        while (curr.left != null) {
            stack.push(curr);
            curr = curr.left;
        }
        stack.push(curr);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            curr = node.right;
            while (curr.left != null) {
                stack.push(curr);
                curr = curr.left;
            }
            stack.push(curr);
        }

        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

package com.joshua.leet;

public class Num112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        Num112 instance = new Num112();
        boolean res = instance.hasPathSum(root, 22);
        System.out.println(res);
    }

    public int sum;
    public int currentSum;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        this.sum = sum;
        return hasPath(root);
    }

    private boolean hasPath(TreeNode node) {
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            if (currentSum == sum) {
                return true;
            } else {
                return false;
            }
        }
        boolean left = false, right = false;
        if (node.left != null) {
            left = hasPath(node.left);
            currentSum -= node.left.val;
        }
        if (node.right != null) {
            right = hasPath(node.right);
            currentSum -= node.right.val;
        }
        return left || right;
    }

    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

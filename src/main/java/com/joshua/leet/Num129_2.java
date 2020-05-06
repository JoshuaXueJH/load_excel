package com.joshua.leet;

public class Num129_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Num129_2 instance = new Num129_2();
        int res = instance.sumNumbers(root);
        System.out.println(res);
    }

    int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        preTraverse(root, 0);
        return sum;
    }

    private void preTraverse(TreeNode node, int partialSum) {
        partialSum = partialSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += partialSum;
        }
        if (node.left != null) {
            preTraverse(node.left, partialSum);
        }
        if (node.right != null) {
            preTraverse(node.right, partialSum);
        }
    }

    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
}

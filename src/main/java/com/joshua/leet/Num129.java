package com.joshua.leet;

public class Num129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Num129 instance = new Num129();
        int res = instance.sumNumbers(root);
        System.out.println(res);
    }

    int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        preTraverse(root, new StringBuilder(" "));
        return sum;
    }

    private void preTraverse(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            sum += Integer.valueOf(sb.toString().trim());
        }
        if (node.left != null) {
            preTraverse(node.left, new StringBuilder(sb));
        }
        if (node.right != null) {
            preTraverse(node.right, new StringBuilder(sb));
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

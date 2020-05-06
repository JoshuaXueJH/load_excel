package com.joshua.leet;

public class Num114_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Num114_2 instance = new Num114_2();
        instance.flatten(root);
        System.out.println();
    }

    TreeNode temp;

    public void flatten(TreeNode root) {
        temp = new TreeNode();
        postTraverse(root);
    }

    private void postTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postTraverse(node.right);
        postTraverse(node.left);
        node.right = temp;
        temp = node;
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

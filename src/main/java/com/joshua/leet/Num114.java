package com.joshua.leet;

public class Num114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Num114 instance = new Num114();
        instance.flatten(root);
        System.out.println();
    }

    TreeNode resNode, currNode;

    public void flatten(TreeNode root) {
        resNode = new TreeNode();
        currNode = resNode;
        traverse(root);
        root.left = null;
        root.right = resNode.right.right;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        currNode.right = new TreeNode(node.val);
        currNode = currNode.right;
        traverse(node.left);
        traverse(node.right);
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

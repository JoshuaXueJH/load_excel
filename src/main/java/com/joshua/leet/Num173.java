package com.joshua.leet;

public class Num173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator1 bstIterator = new BSTIterator1(root);

        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}

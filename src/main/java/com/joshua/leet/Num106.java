package com.joshua.leet;

import java.util.HashMap;
import java.util.Map;

public class Num106 {
    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        Num106 instance = new Num106();
        TreeNode root = instance.buildTree(inorder, postorder);
        System.out.println(root);

    }

    public Map<Integer, Integer> inMap;
    public Integer currentRoot;
    public int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0
                || inorder.length != postorder.length) {
            return null;
        }
        this.postorder = postorder;
        currentRoot = inorder.length - 1;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = postorder[currentRoot];
        currentRoot--;
        TreeNode root = new TreeNode(rootVal);
        root.right = build(inMap.get(rootVal) + 1, right);
        root.left = build(left, inMap.get(rootVal) - 1);
        return root;
    }

    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

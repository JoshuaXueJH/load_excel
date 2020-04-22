package com.joshua.leet;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        BuildTree o = new BuildTree();
        o.buildTree(pre, in);
    }

    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> in_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        this.preorder = preorder;
        this.inorder = inorder;

        int in_idx = 0;
        for (int i : inorder)
            in_map.put(in_idx, i);

        return build(0, inorder.length);
    }

    public TreeNode build(int in_left, int in_right) {
        if (in_left == in_right) return null;

        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        pre_idx++;
        root.left = build(in_left, in_map.get(root_val));
        root.right = build(in_map.get(root_val) + 1, in_right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

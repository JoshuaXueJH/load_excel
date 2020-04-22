package com.joshua.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigzagLevelOrderTraversal o = new ZigzagLevelOrderTraversal();
        o.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        levelTraverse(res, root, 1);
        for (int i = 1; i < res.size(); i += 2) {
            List<Integer> levelRes = res.get(i);
            if (levelRes.size() >= 2)
                reverseLevelRes(levelRes, res, i);
        }
        return res;
    }

    public void reverseLevelRes(List<Integer> levelRes, List<List<Integer>> res, int level) {
        if (levelRes == null || levelRes.size() == 0 || res == null || res.size() == 0)
            return;

        List<Integer> newLevelRes = new ArrayList<>();
        for (int i = levelRes.size() - 1; i >= 0; i--) {
            newLevelRes.add(levelRes.get(i));
        }
        res.set(level, newLevelRes);
    }

    public void levelTraverse(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;

        List<Integer> levelRes;
        if (res.size() < level) {
            levelRes = new ArrayList<>();
            res.add(levelRes);
        } else {
            levelRes = res.get(level - 1);
        }
        levelRes.add(node.val);
        if (node.left != null) {
            levelTraverse(res, node.left, level + 1);
        }
        if (node.right != null) {
            levelTraverse(res, node.right, level + 1);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

package com.joshua.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderTraversal1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal1 o = new LevelOrderTraversal1();
        o.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        levelOutput(res, root, 1);
        return res;
    }

    public void levelOutput(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        List<Integer> levelRes;
        if (res.size() < level) {
            levelRes = new ArrayList();
            res.add(levelRes);
        } else {
            levelRes = res.get(level - 1);
        }
        levelRes.add(node.val);
        if (node.left != null) {
            levelOutput(res, node.left, level + 1);
        }
        if (node.right != null) {
            levelOutput(res, node.right, level + 1);
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

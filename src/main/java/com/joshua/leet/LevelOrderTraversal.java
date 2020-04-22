package com.joshua.leet;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal o = new LevelOrderTraversal();
        o.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNodeWrapper> queue = new LinkedList<>();
        queue.add(new TreeNodeWrapper(1, root));

        int currentLevel = 0;
        boolean levelUp = false;
        while (!queue.isEmpty()) {
            TreeNodeWrapper item = queue.poll();
            if (item.level != currentLevel) {
                currentLevel++;
                levelUp = true;
            }
            if (item.node.left != null)
                queue.add(new TreeNodeWrapper(currentLevel + 1, item.node.left));
            if (item.node.right != null)
                queue.add(new TreeNodeWrapper(currentLevel + 1, item.node.right));
            addNodeToRes(res, currentLevel, levelUp, item.node);
            levelUp = false;
        }
        return res;
    }

    public void addNodeToRes(List<List<Integer>> res, int level, boolean levelUp, TreeNode node) {
        List<Integer> levelRes;
        if (levelUp) {
            levelRes = new ArrayList<>();
            res.add(levelRes);
        } else {
            levelRes = res.get(level - 1);
        }
        levelRes.add(node.val);
    }

    static class TreeNodeWrapper {
        int level;
        TreeNode node;

        public TreeNodeWrapper(int level, TreeNode node) {
            this.level = level;
            this.node = node;
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

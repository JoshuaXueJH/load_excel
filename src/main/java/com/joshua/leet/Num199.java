package com.joshua.leet;

import java.util.*;

public class Num199 {
    private Queue<LevelNode> queue;
    private List<LevelNode> levelTraversal;
    private List<Integer> res;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);

        Num199 o = new Num199();
        List<Integer> res = o.rightSideView(root);
        System.out.println(res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        queue = new LinkedList<>();
        levelTraversal = new ArrayList<>();
        res = new ArrayList<>();

        queue.add(new LevelNode(root, 1));

        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.poll();
            levelTraversal.add(levelNode);
            TreeNode treeNode = levelNode.node;
            int level = levelNode.level;

            if (treeNode.right != null) {
                queue.add(new LevelNode(treeNode.right, level + 1));
            }
            if (treeNode.left != null) {
                queue.add(new LevelNode(treeNode.left, level + 1));
            }
        }

        int currentLevel = 0;
        for (LevelNode item : levelTraversal) {
            if (item.level != currentLevel) {
                res.add(item.node.val);
                currentLevel++;
            }
        }

        return res;
    }

    class LevelNode {
        TreeNode node;
        int level;

        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}

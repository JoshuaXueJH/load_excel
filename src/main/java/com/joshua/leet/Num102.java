package com.joshua.leet;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.*;

public class Num102 {
    public static void main(String[] args) {
        Num102 instance = new Num102();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        long begin = System.currentTimeMillis();
        List<List<Integer>> res = instance.levelOrder(root);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - begin);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<LevelTreeNode> q = new LinkedList<>();
        q.add(new LevelTreeNode(root.val, 1, root.left, root.right));

        int curLevel = 1;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            LevelTreeNode node = q.poll();
            if (node.level != curLevel) {
                curLevel += 1;
                res.add(new ArrayList<Integer>(list));
                list.clear();
            }
            list.add(node.val);
            if (node.left != null) {
                q.add(new LevelTreeNode(node.left.val, curLevel + 1, node.left.left, node.left.right));
            }
            if (node.right != null) {
                q.add(new LevelTreeNode(node.right.val, curLevel + 1, node.right.left, node.right.right));
            }
        }
        res.add(list);
        return res;
    }

    public class LevelTreeNode extends TreeNode {
        int level;

        LevelTreeNode(int x, int level, TreeNode left, TreeNode right) {
            super(x);
            this.level = level;
            this.left = left;
            this.right = right;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

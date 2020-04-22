package com.joshua.leet;

import java.util.*;

public class NumTrees {
    public static void main(String[] args) {
        NumTrees o = new NumTrees();
        List<TreeNode> trees = o.generateTrees(3);
        System.out.println(trees);
    }

    public int numTrees(int n) {
        int[] store = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                store[i] = 1;
                continue;
            }
            int num = 0;
            for (int j = 1; j <= i; j++) {
                num = num + store[j - 1] * store[i - j];
            }
            store[i] = num;
        }
        return store[n];
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0)  return Collections.emptyList();
        Map<Integer, List<TreeNode>> store = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                List<TreeNode> item = new ArrayList<>();
                item.add(i == 0 ? null : new TreeNode(1));
                store.put(i, item);
                continue;
            }

            List<TreeNode> item = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                genNewTrees(item, store, j - 1, i - j);
            }
            store.put(i, item);
        }
        return store.get(n);
    }

    public void genNewTrees(List<TreeNode> list, Map<Integer, List<TreeNode>> store, int leftSize, int rightSize) {
        int rootValue = leftSize + 1;
        List<TreeNode> left = store.get(leftSize);
        List<TreeNode> right = store.get(rightSize);

        for (TreeNode leftNode : left) {
            for (TreeNode rightNode : right) {
                TreeNode node = new TreeNode(rootValue);
                node.left = leftNode;
                node.right = makeRightFit(copyTree(rightNode), rootValue);
                list.add(node);
            }
        }
    }

    public TreeNode makeRightFit(TreeNode node, int toAdd) {
        if (node == null)
            return null;

        traverse(node, toAdd);
        return node;
    }

    public TreeNode copyTree(TreeNode node) {
        if (node == null)
            return null;

        TreeNode root = new TreeNode(node.val);
        root.left = copyTree(node.left);
        root.right = copyTree(node.right);
        return root;
    }

    public void traverse(TreeNode node, int toAdd) {
        if (node == null)
            return;

        if (node.left != null) {
            traverse(node.left, toAdd);
        }
        node.val = node.val + toAdd;
        if (node.right != null) {
            traverse(node.right, toAdd);
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

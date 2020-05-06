package com.joshua.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num95 {
    public static void main(String[] args) {
        Num95 insatance = new Num95();
        insatance.generateTrees(5);
    }

    public List<TreeNode> generateTrees(int n) {
        Map<Integer, List<TreeNode>> store = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                store.put(i, new ArrayList<TreeNode>() {{
                    add(null);
                }});
                continue;
            }
            if (i == 1) {
                store.put(i, new ArrayList<TreeNode>() {{
                    add(new TreeNode(1));
                }});
                continue;
            }
            List<TreeNode> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                List<TreeNode> left = store.get(j - 1);
                List<TreeNode> right = store.get(i - j);
                construct(list, left, j, right);

                store.put(i, list);
            }
        }
        return store.get(n);
    }

    private void construct(List<TreeNode> list, List<TreeNode> left, int rootVal, List<TreeNode> right) {
        List<TreeNode> newRight = new ArrayList<>();
        for (TreeNode node : right) {
            TreeNode newNode = copyNode(node);
            modifyRight(rootVal, newNode);
            newRight.add(newNode);
        }

        for (TreeNode leftItem : left) {
            for (TreeNode rightItem : newRight) {
                TreeNode root = new TreeNode(rootVal);
                root.left = leftItem;
                root.right = rightItem;
                list.add(root);
            }
        }
    }

    private void modifyRight(int val, TreeNode root) {
        if (root == null) {
            return;
        }
        root.val += val;
        modifyRight(val, root.left);
        modifyRight(val, root.right);
    }

    private TreeNode copyNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(node.val);
        newRoot.left = copyNode(node.left);
        newRoot.right = copyNode(node.right);
        return newRoot;
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

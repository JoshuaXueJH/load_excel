package com.joshua.leet;

import java.util.ArrayList;
import java.util.List;

public class Num623 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        Num623 instance = new Num623();
        TreeNode res = instance.addOneRow(root, 1, 3);
        System.out.println(res);
    }

    private List<TreeNode> list;
    private int d;

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        this.d = d;
        levelTraverse(root, 1);
        for (TreeNode node : list) {
            TreeNode lNode = new TreeNode(v);
            TreeNode rNode = new TreeNode(v);
            lNode.left = node.left;
            rNode.right = node.right;
            node.left = lNode;
            node.right = rNode;
        }
        return root;
    }

    private void levelTraverse(TreeNode node, int level) {
        if (node == null) return;
        if (level == d - 1) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(node);
        }
        levelTraverse(node.left, level + 1);
        levelTraverse(node.right, level + 1);
    }
}

package com.joshua.leet;

import java.util.Stack;

public class Num449 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Num449 instance = new Num449();
        String serlizeRes = instance.serialize(root);
        System.out.println(serlizeRes);

        TreeNode deserlizeRes = instance.deserialize(serlizeRes);
        System.out.println(deserlizeRes);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        return preorderSerlize(root);
    }

    private String preorderSerlize(TreeNode node) {
        if (node == null) {
            return "#";
        }
        return node.val + "," + preorderSerlize(node.left) + "," + preorderSerlize(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode p = root;
        boolean pop = false;
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (pop) {
                if (!"#".equals(str)) {
                    pop = false;
                    TreeNode newNode = new TreeNode(Integer.parseInt(str));
                    s.pop().right = newNode;
                    p = newNode;
                    s.push(newNode);
                }
            } else {
                if ("#".equals(str)) {
                    pop = true;
                } else {
                    TreeNode newNode = new TreeNode(Integer.parseInt(str));
                    s.push(newNode);
                    p.left = newNode;
                    p = p.left;
                }
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}

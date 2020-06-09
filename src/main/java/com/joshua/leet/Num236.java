package com.joshua.leet;

import java.util.ArrayList;
import java.util.List;

public class Num236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(17);
        root.left = new TreeNode(-48);
        root.right = new TreeNode(52);
        root.left.left = new TreeNode(-51);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(48);
        root.right.right = new TreeNode(87);

        Num236 instance = new Num236();
        TreeNode res = instance.lowestCommonAncestor(root, root.left.right, root.right.right);
        System.out.println(res);
    }

    List<TreeNode> route1, route2, l;
    TreeNode p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        l = new ArrayList<>();
        this.p = p;
        this.q = q;

        preorderTraverse(root);

        int count = 0;
        while (count < route1.size() || count < route2.size()) {
            if (count < route1.size() && count < route2.size()) {
                if (route1.get(count).val != route2.get(count).val)
                    return route1.get(count - 1);
            } else {
                return route1.get(count - 1);
            }
            count++;
        }
        return null;
    }

    private void preorderTraverse(TreeNode node) {
        if (node == null) return;

        l.add(node);
        if (node.val == p.val)
            route1 = new ArrayList<>(l);
        else if (node.val == q.val)
            route2 = new ArrayList<>(l);

        if (node.left != null) {
            preorderTraverse(node.left);
            l.remove(l.size() - 1);
        }
        if (node.right != null) {
            preorderTraverse(node.right);
            l.remove(l.size() - 1);
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

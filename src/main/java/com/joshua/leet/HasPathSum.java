package com.joshua.leet;

import java.util.ArrayList;

public class HasPathSum {
    private int sum;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        this.sum = sum;

        return findPath(root, 0);
    }

    public boolean findPath(TreeNode node, int routeVal) {
        if(node == null){
            if(routeVal == this.sum){
                return true;
            }
            return false;
        }

        routeVal += node.val;

        boolean left = findPath(node.left, routeVal);
        if(left && node.right == null) return true;
        boolean right = findPath(node.right, routeVal);
        if(right && node.left == null) return true;

        return false;
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        HasPathSum o = new HasPathSum();
        boolean res = o.hasPathSum(root, 1);
        System.out.println(res);
    }
}

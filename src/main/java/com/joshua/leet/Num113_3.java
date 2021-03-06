package com.joshua.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num113_3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Num113_3 instance = new Num113_3();
        List<List<Integer>> res = instance.pathSum(root, 22);
        System.out.println(res);
    }

    List<List<Integer>> res;
    List<Integer> list;
    int sum, currentSum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        this.sum = sum;
        res = new ArrayList<>();
        list = new ArrayList<>();

        allPath(root);

        return res;
    }

    private void allPath(TreeNode node) {
        currentSum += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (currentSum == sum) {
                res.add(new ArrayList<>(list));
            }
        }
        if (node.left != null) {
            allPath(node.left);
            currentSum -= node.left.val;
        }
        if (node.right != null) {
            allPath(node.right);
            currentSum -= node.right.val;

        }
        list.remove(list.size() - 1);
    }

    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

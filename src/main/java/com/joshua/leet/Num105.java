package com.joshua.leet;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Num105 {
    public static void main(String[] args) {
        Num105 instance = new Num105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = instance.buildTree(preorder, inorder);
        System.out.println(JSON.toJSONString(root));
    }

    public int[] pre;
    public List<Integer> inList;
    public int prePointer = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        pre = preorder;
        inList = new ArrayList<>();
        for (int i : inorder) {
            inList.add(i);
        }
        return build(0, preorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prePointer]);
        prePointer++;
        root.left = build(left, inList.indexOf(root.val) - 1);
        root.right = build(inList.indexOf(root.val) + 1, right);
        return root;
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

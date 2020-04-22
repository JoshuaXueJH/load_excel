package com.joshua.leet;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    private List<Integer> biSearchList;
    private int curr = 0;

    public BSTIterator(TreeNode root) {
        biSearchList = new ArrayList<>();
        buildBiSearchTree(root);
    }

    private void buildBiSearchTree(TreeNode node) {
        if (node == null) return;

        buildBiSearchTree(node.left);
        biSearchList.add(node.val);
        buildBiSearchTree(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int num = biSearchList.get(curr);
        curr++;
        return num;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return curr < biSearchList.size();
    }
}

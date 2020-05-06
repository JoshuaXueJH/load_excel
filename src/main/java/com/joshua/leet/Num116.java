package com.joshua.leet;

import java.util.ArrayList;
import java.util.List;

public class Num116 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Num116 instance = new Num116();
        Node res = instance.connect(root);
        System.out.println(res);
    }

    List<List<Node>> levelList;
    List<Node> list;

    public Node connect(Node root) {
        levelList = new ArrayList<>();
        levelTraverse(root, 1);
        return root;
    }

    private void levelTraverse(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level > levelList.size()) {
            list = new ArrayList<>();
            levelList.add(list);
        } else {
            list = levelList.get(level - 1);
            list.get(list.size() - 1).next = node;
        }
        list.add(node);
        levelTraverse(node.left, level + 1);
        levelTraverse(node.right, level + 1);
    }

    static class Node {
        Integer val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

package com.joshua.leet;

import java.util.ArrayList;
import java.util.List;

public class Num116_2 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Num116_2 instance = new Num116_2();
        Node res = instance.connect(root);
        System.out.println(res);
    }

    public Node connect(Node root) {
        midTraverse(root, null, false);
        return root;
    }

    private void midTraverse(Node node, Node parent, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (parent != null) {
            if (isLeft) {
                node.next = parent.right;
            } else if (parent.next != null) {
                node.next = parent.next.left;
            }
        }
        midTraverse(node.left, node, true);
        midTraverse(node.right, node, false);
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

package com.joshua.leet;

public class Connect {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Connect o = new Connect();
        Node res = o.connect(root);
        System.out.println(res);
    }


    public Node connect(Node root) {
        if (root == null || root.left == null) return root;

        buildNext(root);

        return root;
    }

    public void buildNext(Node node) {
        int count = 2, currentCount = count;

        Node currentNode = null;
        Node helperNode = null;
        while (node.left != null) {
            if (currentNode == null) currentNode = node.left;
            if (helperNode == null) helperNode = node;

            while (currentCount > 0) {
                if (currentCount % 2 == 0)
                    currentNode.next = helperNode.right;
                else {
                    if (currentCount == 1)
                        currentNode.next = null;
                    else {
                        currentNode.next = helperNode.next.left;
                        helperNode = helperNode.next;
                    }
                }
                currentNode = currentNode.next;
                currentCount--;
            }
            node = node.left;
            currentNode = node.left;
            helperNode = node;

            count = count * 2;
            currentCount = count;

        }
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}

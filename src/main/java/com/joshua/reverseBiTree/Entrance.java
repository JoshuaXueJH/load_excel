
package com.joshua.reverseBiTree;

import java.util.LinkedList;
import java.util.Stack;

public class Entrance {
    public static void main(String[] args) {
        Node node1111 = new Node(1111);
        Node node1112 = new Node(1112);
        Node node111 = new Node(node1111, node1112, 111);
        Node node112 = new Node(112);
        Node node11 = new Node(node111, node112, 11);
        Node node123 = new Node(123);
        Node node124 = new Node(124);
        Node node12 = new Node(node123, node124, 12);
        Node node1 = new Node(node11, node12, 1);

        System.out.println(node1.value);
        System.out.println(node1.left.value + " " + node1.right.value);
        System.out.println(node1.left.left.value + " " + node1.left.right.value + " " + node1.right.left.value + " " + node1.right.right.value);
        System.out.println(node1.left.left.left.value + " " + node1.left.left.right.value);

        Node revertNode1 = doRevert(node1);
        System.out.println(revertNode1.value);
        System.out.println(revertNode1.left.value + " " + revertNode1.right.value);
        System.out.println(revertNode1.left.left.value + " " + revertNode1.left.right.value + " " + revertNode1.right.left.value + " " + revertNode1.right.right.value);
        System.out.println(revertNode1.right.right.left.value + " " + revertNode1.right.right.right.value);
    }


    /**
     * recursive
     *
     * @param root
     * @return
     */

    public static Node revertTree(Node root) {
        if (root == null) {
            return null;
        }

        swap(root);
        if (root.left != null) {
            revertTree(root.left);
        }
        if (root.right != null) {
            revertTree(root.right);
        }
        return root;
    }

    public static void swap(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null || node.right != null) {
            Node tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }


    /**
     * iterative
     *
     * @param root
     * @return
     */

    public static Node revertTree1(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (queue.size() > 0) {
            Node node = queue.poll();
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    public static Node revertTree2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while ((stack.size() > 0)) {
            Node node = stack.pop();
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    // tuan start
    public static Node doRevert(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            Node currentNodeLeft = currentNode.left;
            Node currentNodeRight = currentNode.right;

            currentNode.left = currentNodeRight;
            currentNode.right = currentNodeLeft;

            currentNode = currentNodeRight;
        }

        return root;
    }
    // tuan end

}


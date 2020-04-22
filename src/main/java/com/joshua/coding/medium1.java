package com.joshua.coding;

import com.joshua.reverseBiTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class medium1 {
    /**
     * Binary Tree Inorder Traversal
     * <p>
     * Given a binary tree,  return the inorder traversal of its nodes' values by iterative implementation.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,3,2]
     */

    public static void main(String[] args) {
        Node node111 = new Node(111);
        Node node112 = new Node(112);
        Node node11 = new Node(node111, node112, 11);
        Node node123 = new Node(123);
        Node node124 = new Node(124);
        Node node12 = new Node(node123, node124, 12);
        Node node1 = new Node(node11, node12, 1);

        System.out.println(node1.value);
        System.out.println(node1.left.value + " " + node1.right.value);
        System.out.println(node1.left.left.value + " " + node1.left.right.value + " " + node1.right.left.value + " " + node1.right.right.value);

        System.out.println("==========");

        List<Integer> res = inorderTraversal(node1);
        res.forEach(item -> System.out.println(item + " "));

    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();

        Stack<Node> stack = new Stack<>();

        if (root.left == null) {
            res.add(root.value);
            Node cursor = popInStack(stack, root.right);
            res.add(cursor.value);
        } else {
            Node cursor = popInStack(stack, root);
            res.add(cursor.value);
        }

        while (stack.size() > 0) {
            Node current = stack.pop();
            res.add(current.value);
            if (current.right != null) {
                Node cursor = popInStack(stack, current.right);
                res.add(cursor.value);
            }
        }
        return res;
    }

    public static Node popInStack(Stack<Node> stack, Node node) {
        Node cursor = node;
        while (cursor.left != null) {
            stack.push(cursor);
            cursor = cursor.left;
        }
        return cursor;
    }
}

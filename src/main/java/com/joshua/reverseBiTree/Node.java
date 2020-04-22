package com.joshua.reverseBiTree;

public class Node {
    public Node left;
    public Node right;
    public Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Node left, Node right, Integer value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}

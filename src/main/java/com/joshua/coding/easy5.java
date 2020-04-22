package com.joshua.coding;

import com.joshua.reverseBiTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class easy5 {
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

        List<List<Integer>> res = levelOrderBottomUp(node1);
        for (List<Integer> a : res) {
            for (Integer b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrderBottomUp(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<NodeWrapper> list = new LinkedList<>();
        list.add(new NodeWrapper(1, root));
        int cursor = 0;
        while (cursor < list.size()) {
            NodeWrapper nw = list.get(cursor);
            if (nw.node.right != null) {
                list.add(new NodeWrapper(nw.level + 1, nw.node.right));
            }
            if (nw.node.left != null) {
                list.add(new NodeWrapper(nw.level + 1, nw.node.left));
            }
            cursor++;
        }

        List<Integer> levelList = new ArrayList<>();
        int currentLevel = list.get(list.size() - 1).level;
        for (int i = list.size() - 1; i >= 0; i--) {
            NodeWrapper nw = list.get(i);
            if (nw.level == currentLevel) {
                levelList.add(nw.node.value);
            } else {
                res.add(new ArrayList<>(levelList));
                levelList.clear();
                levelList.add(nw.node.value);
                currentLevel = nw.level;
            }
        }
        // level 1 hasn't been added to res, add it here
        if (levelList.size() > 0) {
            res.add(levelList);
        }

        return res;
    }

    public static class NodeWrapper {
        Integer level;
        Node node;

        public NodeWrapper(Integer level, Node node) {
            this.level = level;
            this.node = node;
        }
    }
}

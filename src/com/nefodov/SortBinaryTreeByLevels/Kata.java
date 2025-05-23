package com.nefodov.SortBinaryTreeByLevels;

import java.util.LinkedList;
import java.util.List;

public class Kata {
    public static List<Integer> treeByLevels(Node node) {
        List<Integer> res = new LinkedList<>();
        if (node == null) {
            return res;
        }

        List<Node> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            Node currentNode = nodes.get(0);
            nodes.remove(0);

            res.add(currentNode.value);
            if (currentNode.left != null) {
                nodes.add(currentNode.left);
            }

            if (currentNode.right != null) {
                nodes.add(currentNode.right);
            }
        }
        return res;
    }
}

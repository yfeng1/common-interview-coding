package common.algo.ogury;

import java.util.*;

public class Solution1 {
    public static int solution(int[] T) {
        // write your code in Java SE 8
        // generate tree
        if (T.length == 0) {
            return 0;
        }
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < T.length; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 1; i < T.length; i++) {
            nodes.get(i).addConnected(nodes.get(T[i]));
            nodes.get(T[i]).addConnected(nodes.get(i));
        }

        HashSet<Node> used = new HashSet<>();
        used.add(nodes.get(0));
        return getHeight(nodes.get(0), used);
    }


    private static int getHeight(Node node, Set<Node> usedNodes) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);

        int treeHeight = 0;

        int maxHeight = 0;

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0) {
                return treeHeight > maxHeight ? treeHeight : maxHeight;
            }
            treeHeight++;

            while (nodeCount > 0) {
                Node newNode = q.poll();
                boolean isCurrentOdd = newNode.getValue() % 2 == 1;
                if (isCurrentOdd) {
                    int maximum3 = getOddHeight(newNode, usedNodes) + treeHeight;
                    if (maxHeight < maximum3){
                        maxHeight = maximum3;
                    }
                    nodeCount--;
                } else {
                    usedNodes.add(newNode);
                    for (Node node1 : newNode.getConnected()) {
                        if (!usedNodes.contains(node1)) {
                            q.addLast(node1);
                        }
                    }
                    nodeCount--;
                }

            }
        }
    }

    private static int getOddHeight(Node node, Set<Node> usedNodes) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);

        int treeHeight = 0;

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0) {
                return treeHeight;
            }
            treeHeight++;

            while (nodeCount > 0) {
                Node newNode = q.poll();
                boolean isCurrentOdd = newNode.getValue() % 2 == 1;
                if (isCurrentOdd) {
                    nodeCount--;
                    continue;
                } else {
                    usedNodes.add(newNode);
                    for (Node node1 : newNode.getConnected()) {
                        if (!usedNodes.contains(node1)) {
                            q.addLast(node1);
                        }
                    }
                    nodeCount--;
                }
            }
        }
    }

    private final static class Node {
        private int value;
        private List<Node> connected = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addConnected(Node node){
            connected.add(node);
        }

        public int getValue() {
            return value;
        }

        public List<Node> getConnected() {
            return connected;
        }
    }
}

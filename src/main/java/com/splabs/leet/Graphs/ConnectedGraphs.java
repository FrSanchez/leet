package com.splabs.leet.Graphs;

import java.util.*;

public class ConnectedGraphs {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node ans = null;
        Map<Node,Node> copy = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (!copy.containsKey(curr)) {
                Node bis = new Node(curr.val);
                if (ans == null) {
                    ans = bis;
                }
                copy.put(curr, bis);
            }
            for(Node n : curr.neighbors) {
                if (!copy.containsKey(n)) {
                    queue.add(n);
                }
            }
        }
        for(Node src : copy.keySet()) {
            for(Node n : src.neighbors) {
                copy.get(src).neighbors.add(copy.get(n));
            }
        }
        return ans;
    }
}

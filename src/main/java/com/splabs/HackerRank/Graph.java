package com.splabs.HackerRank;

import java.util.*;

public class Graph {
    public static class Hop {
        private final int level;
        private final int node;
        public int getLevel() { return level;}
        public int getNode() { return node; }
        public Hop(int level, int node) {
            this.level = level;
            this.node = node;
        }
    }
    public List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(List<Integer> edge : edges) {
            int src = edge.get(0);
            int dst = edge.get(1);
            if (!graph.containsKey(src)) {
                graph.put(src, new HashSet<>());
            }
            if (!graph.containsKey(dst)) {
                graph.put(dst, new HashSet<>());
            }
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        int [] dist = new int[n+1];
        for(int i = 1; i <= n; i++) {
            dist[i] = -1;
        }
        dist[s] = -2;
        if (graph.containsKey(s)) {
            Queue<Hop> queue = new LinkedList<>();
            queue.add(new Hop(0, s));
            while(!queue.isEmpty()) {
                Hop hop = queue.remove();
                int level = hop.getLevel();
                int node = hop.getNode();
                if (level > 0) {
                    dist[node] = level * 6;
                }
                if (graph.containsKey(node)) {
                    for(int dst : graph.get(node)) {
                        if (dist[dst] == -1) {
                            // not visited
                            queue.add(new Hop(level + 1, dst));
                        }
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if (dist[i] != -2) {
                list.add(dist[i]);
            }
        }
        return list;
    }
}

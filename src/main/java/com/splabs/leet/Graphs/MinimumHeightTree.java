package com.splabs.leet.Graphs;

import java.util.*;

public class MinimumHeightTree {
    Set<Integer> visited;

    public MinimumHeightTree() {
        visited = new HashSet<>();
    }

    public Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            for (int node : edge) {
                if (!graph.containsKey(node)) {
                    graph.put(node, new ArrayList<>());
                }
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            return null;
        }
        int minH = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        for(Integer root : graph.keySet()) {
            visited = new HashSet<>();
            int h = dfsForMaxDepth(root, graph);
            if (h < minH) {
                ans.clear();
                minH = h;
            }
            if (h == minH) {
                ans.add(root);
            }
        }
        return ans;
    }


    public int dfsForMaxDepth(Integer root, Map<Integer, List<Integer>> graph) {

        if (graph.get(root).size() == 0) {
            return 1;
        }

        int maxDepth = 0;
        visited.add(root);
        for(Integer n : graph.get(root)) {
            if (!visited.contains(n)) {
                maxDepth = Math.max(maxDepth, dfsForMaxDepth(n, graph));
            }
        }

        return maxDepth + 1;
    }
}

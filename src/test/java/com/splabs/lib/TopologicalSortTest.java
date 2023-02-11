package com.splabs.lib;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSortTest {
    @Test
    public void sortGraph() {
        final int N = 7;
        Map<Integer, List<TopologicalSort.Edge>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        graph.get(0).add(new TopologicalSort.Edge(0, 1, 3));
        graph.get(0).add(new TopologicalSort.Edge(0, 2, 2));
        graph.get(0).add(new TopologicalSort.Edge(0, 5, 3));
        graph.get(1).add(new TopologicalSort.Edge(1, 3, 1));
        graph.get(1).add(new TopologicalSort.Edge(1, 2, 6));
        graph.get(2).add(new TopologicalSort.Edge(2, 3, 1));
        graph.get(2).add(new TopologicalSort.Edge(2, 4, 10));
        graph.get(3).add(new TopologicalSort.Edge(3, 4, 5));
        graph.get(5).add(new TopologicalSort.Edge(5, 4, 7));

        int[] ordering = TopologicalSort.topologicalSort(graph, N);

        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        System.out.println(java.util.Arrays.toString(ordering));

        // Finds all the shortest paths starting at node 0
        Integer[] dists = TopologicalSort.dagShortestPath(graph, 0, N);
        System.out.println(java.util.Arrays.toString(dists));

        // Find the shortest path from 0 to 4 which is 8.0
        System.out.println(dists[4]);

        // Find the shortest path from 0 to 6 which
        // is null since 6 is not reachable!
        System.out.println(dists[6]);
    }
}

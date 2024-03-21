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
        int start = 0;
        Integer[] dists = TopologicalSort.dagShortestPath(graph, start, N);
        for(int i = 0; i < N; i++) {
            System.out.printf("%d->%d: %d  ", start,i, dists[i]);
        }
    }

    @Test
    public void sortGraph2() {
        final int N = 6;
        Map<Integer, List<TopologicalSort.Edge>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        graph.get(5).add(new TopologicalSort.Edge(5, 2, 1));
        graph.get(5).add(new TopologicalSort.Edge(5, 0, 1));
        graph.get(4).add(new TopologicalSort.Edge(4, 1, 1));
        graph.get(4).add(new TopologicalSort.Edge(4, 0, 1));
        graph.get(2).add(new TopologicalSort.Edge(2, 3, 1));
        graph.get(3).add(new TopologicalSort.Edge(3, 1, 1));

        int[] ordering = TopologicalSort.topologicalSort(graph, N);

        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        System.out.println(java.util.Arrays.toString(ordering));

        // Finds all the shortest paths starting at node 0
        int start = 5;
        Integer[] dists = TopologicalSort.dagShortestPath(graph, start, N);
//        System.out.println(java.util.Arrays.toString(dists));
        for(int i = 0; i < N; i++) {
            System.out.printf("%d->%d: %d  ", start,i, dists[i]);
        }

    }
}

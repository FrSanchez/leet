package com.splabs.lib;

import java.util.*;

public class Graph<T> {

    private final Map<T, Set<T>> graph;

    public Map<T, Set<T>> getGraph() {
        return graph;
    }

    public boolean hasNode(T node) {
        return graph.containsKey(node);
    }

    public Graph()
    {
        graph = new HashMap<>();
    }

    private void putNode(T node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new HashSet<>());
        }
    }

    public void addEdge(T source, T dest) {
        putNode(source);
        putNode(dest);
        graph.get(source).add(dest);
        graph.get(dest).add(source);
    }
}

package com.splabs.leet.Graphs;

import java.util.*;

public class CourseSchedule {

    private Map<Integer, List<Integer>> graph;
    private List<Integer> addNode(int node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        return graph.get(node);
    }

    private boolean dfs(int at, Set<Integer> visited) {
        visited.add(at);
        if (!canDo[at]) {
            for (int adj : graph.get(at)) {
                if (!visited.contains(adj)) {
                    if (!dfs(adj, visited)) {
                        return false;
                    }
                } else {
                    System.out.println("loop");
                    return false;
                }
            }
        }
        visited.remove(at);
        return true;
    }

    boolean[] canDo;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>(numCourses);
        canDo = new boolean[numCourses];
        for(int c = 0; c < numCourses; c++) {
            addNode(c);
        }
        for(int[] prereq : prerequisites) {
            addNode(prereq[1]);
            addNode(prereq[0]).add(prereq[1]);
        }
        for(int c : graph.keySet()) {
            if (graph.get(c).size() == 0) {
                canDo[c] = true;
            }
        }
        System.out.println(graph);

        Set<Integer> visited = new HashSet<>();
        for(int c = numCourses - 1; c >=0; c--) {
            visited.clear();
            if (!dfs(c, visited)) {
                return false;
            }
            canDo[c] = true;
        }
        return true;
    }
}

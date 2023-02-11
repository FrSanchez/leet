package com.splabs.leet.Graphs;

import java.util.*;

public class CourseScheduleII {

    Map<Integer, List<Integer>> graph ;

    private List<Integer> addNode(int n) {
        if (!graph.containsKey(n)) {
            graph.put(n, new ArrayList<>());
        }
        return graph.get(n);
    }

    private boolean dfs(int course, Set<Integer> visited, List<Integer> order) {
        visited.add(course);
        if (hasCycle(course, new HashSet<>())) {
            return false;
        }
        for(Integer adj : graph.get(course)) {
            if (!visited.contains(adj)) {
                dfs(adj, visited, order);
            }
        }
        order.add(course);
        return true;
    }

    private boolean hasCycle(int course, Set<Integer> visited) {
        visited.add(course);
        for(Integer adj : graph.get(course)) {
            if (visited.contains(adj)) {
                return true;
            }
            if (hasCycle(adj, visited)) {
                return true;
            }
        }
        visited.remove(course);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            addNode(i);
        }
        for(int[] prereq : prerequisites) {
            addNode(prereq[0]).add(prereq[1]);
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (!dfs(i, visited, order)) {
                    return new int[0];
                }
            }
        }

        int[] array = new int[order.size()];
        for(int i = 0; i < order.size(); i++) array[i] = order.get(i);
        return array;
    }
}

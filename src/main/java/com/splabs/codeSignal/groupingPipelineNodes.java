package com.splabs.codeSignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupingPipelineNodes {
    /*
     * You're testing a new feature that allows users to group nodes together, in
     * order to help
     * simplify the appearance of the pipeline.
     * 
     * Since the data should always flow in one direction, it should not be possible
     * for the user
     * to group the nodes in such a way that the resulting pipeline contains cycles.
     * Self-loops can be hidden after grouping, therefore any self-loop is not
     * considered
     * as a cycle for the task at hand.
     * 
     * Given an integer n representing the number of nodes in the pipeline,
     * a list of directed edges g, and an array v containing all the nodes to be
     * merged,
     * your task is to figure out whether or not the resulting pipeline will be
     * valid
     * (i.e., will not contain any cycles).
     */

    Map<Integer, List<Integer>> map;

    boolean solution(int n, int[][] g, int[] v) {
        map = new HashMap<>();
        for (int[] e : g) {
            for (int i = 0; i < 2; i++) {
                if (!map.containsKey(e[i])) {
                    map.put(e[i], new ArrayList<>());
                }
            }
            map.get(e[0]).add(e[1]);
        }


        boolean[] visited = new boolean[n+1];
        boolean[] recStack = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            if (isCyclic(i, visited, recStack)) {
                System.out.println(recStack);
                return false;
            }
        }
        System.out.println("Not cyclic");
        return true;
    }

    public boolean isCyclic(int i, boolean[] visited, boolean[] recStack) {
        System.out.printf("isCyclic(%d) ", i);
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = map.get(i);

        if (children == null) {
            System.out.println(map);
            return false;
        }

        for(Integer c : children) {
            if (isCyclic(c, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}

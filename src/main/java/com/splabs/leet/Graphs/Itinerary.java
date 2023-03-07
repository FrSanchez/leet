package com.splabs.leet.Graphs;

import java.util.*;

public class Itinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) {
            return new ArrayList<>();
        }

        Map<String, Set<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new HashSet<>());
            }
            if (!graph.containsKey(ticket.get(1))) {
                graph.put(ticket.get(1), new HashSet<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> answer = new ArrayList<>();
        dfs(graph, "JFK", new TreeSet<>());
        return answer;
    }

    private void dfs(Map<String, Set<String>> graph, String curr, Set<String> visited) {
        visited.add(curr);
        int next = 0;
        for(String dest : graph.get(curr)) {
            if (!visited.contains(dest)) {
                dfs(graph, dest, visited);
                next++;
            }
        }
        if (next == 0) {
            System.out.println(visited);
        }
        visited.remove(curr);
    }
}

package com.splabs.interviewCake;

import java.util.*;

/*
Instead of routing texts through cell towers, your app sends messages via the phones of nearby users, passing each message along from one phone to the next until it reaches the intended recipient. (Don't worry—the messages are encrypted while they're in transit.)

Some friends have been using your service, and they're complaining that it takes a long time for messages to get delivered. After some preliminary debugging, you suspect messages might not be taking the most direct route from the sender to the recipient.

Given information about active users on the network, find the shortest route for a message from one user (the sender) to another (the recipient). Return a list of users that make up this route.
 */
public class MeshMessage {
    private Map<String, Set<String>> buildGraph(List<List<String>> network) {
        Map<String, Set<String>> graph = new HashMap<>();
        for(var line : network) {
            int i = 0;
            String head = line.get(0);
            graph.put(head, new HashSet<>());
            for(String name : line) {
                if(i > 0) {
                    graph.get(head).add(name);
                }
                i++;
            }
        }
        return graph;
    }

    static private class Pair {
        public String from;
        public String to;
        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair p2 = (Pair)o;
            return from.equalsIgnoreCase(p2.from) && to.equalsIgnoreCase(p2.to);
        }
        public String toString() {
            return from + "->" + to;
        }
    }

    public List<String> shortestRoute(List<List<String>> network, String from, String to) {
        var graph = buildGraph(network);
        Queue<String> queue = new LinkedList<>();
        queue.offer(from);
        Map<String, String> visited = new HashMap<>();
        visited.put(from, null);
        while(!queue.isEmpty()) {
            String curr = queue.poll();
            for(String other : graph.getOrDefault(curr, new HashSet<>())) {
                if (!visited.containsKey(other)) {
                    queue.add(other);
                    visited.put(other, curr);
                    if (other.equalsIgnoreCase(to)) {
                        return buildAnswer(visited, from, to);
                    }
                }
            }
        }
        return null;
    }

    private List<String> buildAnswer(Map<String, String> visited, String from, String to) {
        ArrayList<String> answer = new ArrayList<>();
        String curr = to;
        while(curr != null) {
            answer.add(0, curr);
            curr = visited.get(curr);
        }
        return answer;
    }
}

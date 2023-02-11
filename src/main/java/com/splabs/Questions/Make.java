package com.splabs.Questions;

import java.util.*;

/*
implement a clone of make - without all the complex features
exmaple:
---- start ---
red:
    echo "Compile RED" > red
blue:
    echo "Compile BLUE" > blue

purple: blue red
    echo "Compiling purple" > purple
    cat red blue >> purple
---- end ----
 */
public class Make {

    Map<String, List<String>> graph;
    Map<String, List<String>> commands;

    public void debug() {
        System.out.println(graph);
        System.out.println(commands);
    }
    public Make() {
        graph = new HashMap<>();
        commands = new HashMap<>();
    }

    private void buildHelper(String target) {
        for(String cmd : commands.get(target)) {
            System.out.println(cmd);
        }
    }
    private void dfs(String at, Set<String> visited, Set<String> built) throws Exception {
        if (!graph.containsKey(at)) {
            throw new Exception("target not found : " + at);
        }
        visited.add(at);
        for(String adj : graph.get(at)) {
            if (visited.contains(adj)) {
                throw new Exception("cycle detected, can´t build");
            }
            if (!built.contains(at)) {
                dfs(adj, visited, built);
            }
        }
        visited.remove(at);
        if (!built.contains(at)) {
            built.add(at);
            buildHelper(at);
        }
    }

    public void build(String target) throws Exception {
        Set<String> visited = new HashSet<>();
        dfs(target, visited, new HashSet<>());
    }

    private void addNodeIfMissing(String node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        if (!commands.containsKey(node)) {
            commands.put(node, new ArrayList<>());
        }
    }

    public void parseInput(String[] lines) {
        String target = null;
        for(String line : lines) {
            if (line.matches("^[a-z]+.*:.*$")) {
                String[] parts = line.split(":");
                target = parts[0];
                addNodeIfMissing(target);
                if (parts.length > 1) {
                    String[] deps = parts[1].split("\\s+");
                    for (String dep : deps) {
                        if (dep.isEmpty()) {
                            continue;
                        }
                        addNodeIfMissing(dep);
//                        graph.get(dep).add(target);
                        graph.get(target).add(dep);
                    }
                }
            } else {
                if (line.matches("\\s+[a-zA-Z]+.*$")) {
                    commands.get(target).add(line.trim());
                }
            }
        }
    }

    /**
     * Accepts a list of string dependencies
     * An empty dependency is just a single element in the array
     * The first element is the target, if any, the rest are the dependencies
     * [blue],[red],[purple,red,blue]
     *
     * @param dependencies
     */
    public void initGraph(String[][] dependencies) {
        graph = new HashMap<>();

        for(String[] deps : dependencies) {
            String target = deps[0];
            List<String> targetDeps = new ArrayList<>();
            for(int i = 1; i < deps.length; i++) {
                targetDeps.add(deps[i]);
            }
            graph.put(target, targetDeps);
        }
    }

    public void addCommands(String target, List<String> commands0) {
    }
}

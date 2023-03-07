package com.splabs.lib;

import java.util.*;

public class Synonyms {
    /*
Given a list of synonyms (represented as a pair of words separated by a space, 1 per line) and a sentence, print out all possible “equivalent” sentences.

Example
List of synonyms:
happy joyful
glad happy
sad sorrowful

Input string:
I am happy and sad

Output:
I am happy and sad
I am happy and sorrowful
I am joyful and sad
I am joyful and sorrowful
I am glad and sad
I am glad and sorrowful


 * Click `Run` to execute the snippet below!
 */

//        public static void main(String[] args) {
//            List<String> syn = Arrays.asList("happy","joyful","glad","happy","sad","sorrowful");
//            generateSynonims(syn, "I am happy and sad");
//        }
    Graph<String> graph = new Graph<>();
    Graph<String> dup = new Graph<>();

    private void grabSynonyms(String curr, Set<String> visited) {
        Queue<String> queue = new LinkedList<>();
        queue.add(curr);
        while(!queue.isEmpty()) {
            curr = queue.poll();
            visited.add(curr);
            for(String adj : graph.getGraph().get(curr)) {
                if (!visited.contains(adj)) {
                    queue.add(adj);
                }
            }
        }
    }
    public void findSynonyms(List<String> synonyms, String phrase) {
        Map<String, Set<String>> dupe = new HashMap<>();
        for(int i = 0; i < synonyms.size(); i+=2) {
            graph.addEdge(synonyms.get(i), synonyms.get(i+1));
            if (!dupe.containsKey(synonyms.get(i))) {
                dupe.put(synonyms.get(i), new HashSet<>());
            }
            if (!dupe.containsKey(synonyms.get(i+1))) {
                dupe.put(synonyms.get(i+1), new HashSet<>());
            }
        }
//        System.out.println(graph.getGraph());
        List<String> prev = new ArrayList<>();


        prev.add("");
        String start = null;
        for(String word : phrase.split("\\s+")) {
            System.out.println(word);
            if (!dupe.containsKey(word)) {
                dupe.put(word, new HashSet<>());
            }
            if (start == null) {
                start = word;
            }
            if (graph.hasNode(word)) {
                Set<String> syns = new HashSet<>();
                grabSynonyms(word, syns);
                for(String syn : syns) {
                    for(String p : prev) {
                        dupe.get(p).add(syn);
                    }
                }
                prev = new ArrayList<>(syns);
            } else {
                if (start.compareTo(word) != 0) {
                    for (String p : prev) {
                        dupe.get(p).add(word);
                    }
                }
                prev.clear();
                prev.add(word);
            }
        }
        System.out.println(dupe);
        printAll(dupe, start, new TreeSet<>(), new ArrayList<String>());
    }

    private void printAll(Map<String, Set<String>> dup, String node, Set<String> visited, List<String> output) {
        visited.add(node);
        output.add(node);
        boolean leaf = true;
        for(String adj : dup.get(node)) {
            if (!visited.contains(adj)) {
                printAll(dup, adj, visited, output);
            }
            leaf = false;
        }
        if (leaf) {
            System.out.println(output);
        }
        output.remove(node);
        visited.remove(node);
    }

    public void duplicatePrefix(List<StringBuilder> prefix, String word, Set<String> syns) {
        if (prefix.isEmpty()) {
            prefix.add(new StringBuilder());
            prefix.get(0).append(' ').append(word);
            return;
        }
        int sz = prefix.size();
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = prefix.get(i);
            sb.append(' ');
            for (String syn : syns) {
                StringBuilder dup = new StringBuilder(sb);
                dup.append(syn);
                prefix.add(dup);
            }
            sb.append(word);
        }
    }

    public void generateSynonyms(List<String> synonyms, String phrase) {
        Map<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < synonyms.size(); i += 2) {
            String w1 = synonyms.get(i);
            String w2 = synonyms.get(i + 1);
            if (!map.containsKey(w1)) {
                map.put(w1, new HashSet<>());
            }
            if (!map.containsKey(w2)) {
                map.put(w2, new HashSet<>());
            }
            map.get(w1).add(w2);
            map.get(w2).add(w1);
            map.get(w2).addAll(map.get(w1));
            map.get(w1).addAll(map.get(w2));
        }
        System.out.println(map);
        String[] words = phrase.split("\\s+");
        List<StringBuilder> prefix = new ArrayList<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                duplicatePrefix(prefix, word, map.get(word));
            } else {
                if (prefix.isEmpty()) {
                    prefix.add(new StringBuilder(word));
                } else {
                    for (StringBuilder sb : prefix) {
                        sb.append(' ').append(word);
                    }
                }
            }
        }
        System.out.println(prefix);
    }
}




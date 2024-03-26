package com.splabs.HackerRank;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class DNAHealth {
    public static class Sample {
        public int first;
        public int last;
        public String d;
        public Sample(int f, int l, String d) {
            this.first = f;
            this.last = l;
            this.d = d;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<Integer> indices = new ArrayList<>();

        public static TrieNode buildTree(List<String> genes) {
            TrieNode root = new TrieNode();

            for (int i = 0; i < genes.size(); i++) {
                String gene = genes.get(i);

                TrieNode currentNode = root;
                for (char c : gene.toCharArray()) {
                    currentNode.children.putIfAbsent(c, new TrieNode());
                    currentNode = currentNode.children.get(c);
                }
                currentNode.indices.add(i);
            }
            return root;
        }
    }


    public static long determineDNA(TrieNode root, List<Integer> health, int first, int last, String d) {
        long healthSum = 0;

        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < d.length(); i++) {
            TrieNode currentNode = root;
            for (int j = i; j < d.length(); j++) {
                char c = d.charAt(j);
                if (!currentNode.children.containsKey(c)) break;

                currentNode = currentNode.children.get(c);
                currentNode.indices
                        .stream()
                        .filter(n->(n>=first && n<=last))
//                        .map(health::get)
                        .forEach(idxs::add);
            }
        }
        healthSum = idxs.stream().map(health::get).mapToLong(a->a).sum();
        return healthSum;
    }

    private static long getHealthSum(List<Integer> indices, List<Integer> health, int first, int last) {
        long sum = 0;
        for (int index : indices) {
            if (index >= first && index <= last) {
                sum += health.get(index);
            }
        }
        return sum;
    }

    public static void dnaHealth(List<String> genes, List<Integer> health, List<Sample> samples) {TrieNode root = TrieNode.buildTree(genes);
        long max = 0;
        long low = Long.MAX_VALUE;
        for(Sample sample : samples) {
            long h = determineDNA(root, health, sample.first, sample.last, sample.d);
            if (h > max) {
                max = h;
            }
            if (h < low) {
                low = h;
            }
        }

        System.out.println(low + " " + max);
    }
    public static void CalculateHealth(List<String> args) throws IOException {
        List<String> genes = Stream.of(args.get(1).replaceAll("\\s+$", "").split(" ")).collect(toList());
        List<Integer> health = Stream.of(args.get(2).replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        int s = Integer.parseInt(args.get(3));
        List<Sample> samples = new ArrayList<>(s);
        for (int i = 0; i < s; i++) {
            String[] firstMultipleInput = args.get(i + 4).replaceAll("\\s+$", "").split(" ");
            int first = Integer.parseInt(firstMultipleInput[0]);
            int last = Integer.parseInt(firstMultipleInput[1]);
            String d = firstMultipleInput[2];
            samples.add(new Sample(first, last, d));
        }
        dnaHealth(genes, health, samples);
    }
    public static void LoadFromFile(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        List<Sample> samples = new ArrayList<>(s);
        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];
                samples.add(new Sample(first, last, d));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        dnaHealth(genes, health, samples);

        bufferedReader.close();
    }
}

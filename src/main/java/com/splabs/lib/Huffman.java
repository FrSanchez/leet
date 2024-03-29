package com.splabs.lib;

import java.io.*;
import java.util.*;

public class Huffman {

    public static class FileData implements Serializable {
        int len;
        Map<Character, Integer> frequencyMap;
        BitSet bitSet;

        public void write(OutputStream outputStream) throws IOException {
            DataOutputStream output = new DataOutputStream(outputStream);
            output.writeInt(len);
            output.writeInt(frequencyMap.size());
            for(Character c : frequencyMap.keySet()) {
                output.writeChar(c);
                output.writeInt(frequencyMap.get(c));
            }
            output.write(bitSet.toByteArray());
            output.close();
        }

        public void read(FileInputStream inp) throws IOException {
            DataInputStream input = new DataInputStream(inp);
            len = input.readInt();
            frequencyMap = new HashMap<>();
            for(int num = input.readInt(); num > 0; num--) {
                char c = input.readChar();
                int freq = input.readInt();
                frequencyMap.put(c, freq);
            }
            byte[] bytes = input.readAllBytes();
            bitSet = BitSet.valueOf(bytes);

            input.close();
        }
    }

    public static class Node {
        private final char symbol;
        private final int freq;
        private Node left, right;

        public Node(char data) {
            this(data, 0);
        }

        public Node(char data, int freq) {
            symbol = data;
            this.freq = freq;
            left = null;
            right = null;
        }

        public char getSymbol() { return symbol; }
        public int getFrequency() { return freq; }
        public Node getLeft() { return left; }
        public Node getRight() { return right; }
    };

    public String decode(Node root, int n, BitSet input) {
        StringBuilder output = new StringBuilder();
        Node curr = root;
        for(int i = 0; i < n; i++) {
            if (input.get(i)) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
            if (curr.left == null && curr.right == null) {
                output.append(curr.symbol);
                curr = root;
            }
        }
        return output.toString();
    }

    public void encode(String input, OutputStream outputStream) throws IOException {
        Map<Character, Integer> map = freq(input);
        Node root = buildTree(map);
        Map<Character, String> dictionary = buildDictionary(map, root);
        StringBuilder sb = new StringBuilder();
        for(Character c : input.toCharArray()) {
            sb.append(dictionary.get(c));
        }
        FileData fd = new FileData();
        fd.frequencyMap = map;
        fd.len = sb.length();
        fd.bitSet = new BitSet(fd.len);
        for(int i = 0; i < fd.len; i++) {
            char c = sb.charAt(i);
            if (c=='1') { fd.bitSet.set(i); }
        }
        fd.write(outputStream);
    }

    public String decodeFile(FileInputStream inp) throws IOException, ClassNotFoundException {
        FileData fd = new FileData();
        fd.read(inp);
        Node root = buildTree(fd.frequencyMap);
        return decode(root, fd.len, fd.bitSet);
    }

    private void dfs(Node curr, String path, Map<Character, String> dict) {

        if (curr.left == null && curr.right == null) {
            dict.put(curr.symbol, path);
        }
        else {
            if (curr.left != null) {
                dfs(curr.left, path + "0", dict);
            }
            if (curr.right != null) {
                dfs(curr.right, path + "1", dict);
            }
        }
    }

    private Map<Character, String> buildDictionary(Map<Character, Integer> map , Node root) {
        Map<Character, String> dict = new HashMap<>(map.size());
        dfs(root, "", dict);
        return dict;
    }


    private Node buildTree(Map<Character, Integer> map) {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return Integer.compare(node.freq, t1.freq);
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(map.size(), comparator);
        for(Character c : map.keySet()) {
            Node node = new Node(c, map.get(c));
            queue.add(node);
        }
        while(queue.size() > 1) {
            Node n1 = queue.remove();
            Node n2 = queue.remove();
            Node parent = new Node('\0', n1.freq + n2.freq);
            parent.left = n1;
            parent.right = n2;
            queue.add(parent);
        }
        return queue.remove();
    }

    private  Map<Character, Integer> freq(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : input.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        return map;
    }
}

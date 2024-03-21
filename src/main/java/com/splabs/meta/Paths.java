package com.splabs.meta;

import java.util.ArrayList;
import java.util.List;

public class Paths {
    private class Node {
        public String name;
        public List<Node> children;
        public Node parent;
        public Node(String name) {
            this(name, null);
        }
        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }
    Node buildTree(String cwd) {
        Node root = new Node("");
        Node curr = root;
        String [] parts =cwd.split("/");
        for(String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            Node next = new Node(part, curr);
            curr.children.add(next);
            curr = next;
        }
        return root;
    }

    private Node find(Node curr, String name) {
        for(Node child : curr.children) {
            if (child.name.contentEquals(name)) {
                return child;
            }
        }
        return null;
    }
    public String cd(String cwd, String arg) {
        Node root = buildTree(cwd);
        Node curr = root;
        String[] steps = arg.split("/");
        if (arg.charAt(0) != '/') {
            while(!curr.children.isEmpty()) {
                curr = curr.children.get(0);
            }
        }
        for(String step : steps) {
            if (!step.isEmpty()) {
                if (step.equalsIgnoreCase("..")) {
                    if (curr.parent != null) {
                        curr = curr.parent;
                    }
                    continue;
                }
                if (step.equalsIgnoreCase(".")) {
                    continue;
                }
                Node next = find(curr, step);
                if (next == null) {
                    next = new Node(step, curr);
                    curr.children.add(next);
                }
                curr = next;
            }
        }
        StringBuilder ans = new StringBuilder();
        while(curr!=null && !curr.name.isEmpty()) {
            ans.insert(0, curr.name);
            ans.insert(0, '/');
            curr=curr.parent;
        }
        return ans.toString();
    }
}

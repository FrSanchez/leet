package com.splabs.leet.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CreteBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        var parents = new HashMap<Integer, TreeNode>();
        var children = new HashMap<Integer, TreeNode>();
        TreeNode root = null;
        for (int[] desc : descriptions) {
            int p = desc[0];
            int c = desc[1];
            boolean left = desc[2] == 1;
            TreeNode parent, child = null;
            if (children.containsKey(p)) {
                parent = children.get(p);
            } else {
                if (!parents.containsKey(p)) {
                    parents.put(p, new TreeNode(p));
                }
                parent = parents.get(p);
            }
            if (parents.containsKey(c)) {
                child = parents.get(c);
                parents.remove(c);
            }
            if (!children.containsKey(c)) {
                child = child == null ? new TreeNode(c) : child;
                children.put(c, child);
            }
            child = children.get(c);
            if (left) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        if (parents.size() > 1) {
            // find the actual root
        } else {
            root = parents.values().iterator().next();
        }
        return root;
    }
}


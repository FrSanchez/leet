package com.splabs.leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        level.add(1);
        Integer l = 0;
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            l = level.poll();
            if (curr.left == null && curr.right == null) {
                return l;
            }
            if (curr.left != null) {
                queue.add(curr.left);
                level.add(l + 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                level.add(l+1);
            }
        }
        return l;
    }
}

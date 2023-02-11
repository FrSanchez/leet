package com.splabs.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return (isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        TreeNode cl = p;
        TreeNode cr = q;
        Queue<TreeNode> ql = new LinkedList<>();
        Queue<TreeNode> qr = new LinkedList<>();
        ql.add(p);
        qr.add(q);
        while (!ql.isEmpty()) {
            cl = ql.poll();
            cr = qr.poll();
            if (cl == null && cr == null) {
                return true;
            }
            if (cl == null || cr == null) {
                return false;
            }
            if (cl.val != cr.val) {
                return false;
            }
            ql.add(cl.left);
            ql.add(cl.right);
            qr.add(cr.left);
            qr.add(cr.right);
        }
        return true;
    }

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return areSymmetric(root.left, root.right);
    }

    public boolean areSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return (areSymmetric(p.left, q.right) && areSymmetric(p.right, q.left));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderRecursive(root, 0, result);
        return result;
    }

    public void levelOrderRecursive(TreeNode root, int level, List<List<Integer>> output) {
        if (root != null) {
            if (output.size() <= level) {
                output.add(new ArrayList<>());
            }
            output.get(level).add(root.val);
            levelOrderRecursive(root.left, level +1, output );
            levelOrderRecursive(root.right, level + 1, output);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrderRecursive(root, 0, result);
        return result;
    }

    public void zigzagLevelOrderRecursive(TreeNode root, int level, List<List<Integer>> result) {
        if (root != null) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            if (level % 2 == 0) {
                result.get(level).add(root.val);
            } else {
                result.get(level).add(0, root.val);
            }
            zigzagLevelOrderRecursive(root.left, level+1, result);
            zigzagLevelOrderRecursive(root.right, level+1, result);
        }
    }

}

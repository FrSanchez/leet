package com.splabs.leet.Trees;

import org.junit.jupiter.api.Test;

public class CreateBinaryTreeTest {
    @Test
    public void Case4() {
        var cbt = new CreteBinaryTree();
        var root = cbt.createBinaryTree(new int[][] {
                {20, 15, 1},
                {20, 17, 0},
                {50, 19, 0},
                {50, 80, 1},
                {80, 27, 0}
        });
    }

    @Test
    public void Case5() {
        var cbt = new CreteBinaryTree();
        var root = cbt.createBinaryTree(new int[][] {
                { 39, 70, 1 },
                { 13, 39, 1 },
                {85,74,1},
                {74,13,1},
                {38,82,1},
                {82,85,1}
        });}
}

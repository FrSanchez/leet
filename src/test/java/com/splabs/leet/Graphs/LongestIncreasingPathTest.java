package com.splabs.leet.Graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingPathTest {

    private void testMatrix(int[][] matrix, int longestPath) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        int c = lip.longestIncreasingPath(matrix);
        assertEquals(longestPath, c);
    }
    @Test
    public void test() {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        testMatrix(matrix, 4);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        testMatrix(matrix, 4);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1}
        };
        testMatrix(matrix, 1);
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {1,2},
                {2,3}
        };
        testMatrix(matrix, 3);
    }

    @Test
    public void test5() {
        testMatrix(new int[][] {
                {7,8,9},
                {9,7,6},
                {7,2,3}
        }, 6);
    }
}

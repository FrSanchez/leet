package com.splabs.leet.Graphs;

/*
You are given a 2D integer array grid of size m * n.

You start at the top-left cell (0, 0) and want to reach the bottom-right cell (m - 1, n - 1).

At each step, you may move either right or down.

The cost of a path is defined as the bitwise XOR of all the values in the cells along that path, including the start and end cells.

Return the minimum possible XOR value among all valid paths from (0, 0) to (m - 1, n - 1).
 */
public class MinimumXORPath {
    private int costDfs(int[][] grid, int cost, int x, int y) {
        cost = cost ^ grid[y][x];
        if (y == grid.length -1 && x == grid[0].length - 1) {
            return cost;
        }
        // System.out.printf("(%d, %d)=%d [%d]\n",x,y,grid[y][x],cost);
        int cright = Integer.MAX_VALUE, cdown = Integer.MAX_VALUE;
        if (x+1 < grid[0].length) {
            cright = costDfs(grid, cost, x + 1, y);
        }
        if (y+1 < grid.length) {
            cdown = costDfs(grid, cost, x, y + 1);
        }
        return Math.min(cright, cdown);
    }

    public int minCost(int[][] grid) {
        return costDfs(grid, 0, 0, 0);
    }
}

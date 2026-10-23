package com.splabs.leet.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.Stack;

/*

200. Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


 */
public class NumIslands {
    private static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public String toString() {
            return String.format("(%d,%d)",x,y);
        }
    }

    private int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    private int width;
    private int height;

    private void bfs(char[][] grid, Point start, int cnt) {
        Queue<Point> queue = new LinkedList<>();
        char nc = (char)(cnt + '0');
        queue.offer(start);
        Point c;
        while(!queue.isEmpty()) {
            c = queue.poll();
            grid[c.y][c.x] = nc;
            for(int[] dir : dirs) {
                int nx = c.x + dir[0];
                int ny = c.y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && grid[ny][nx] == '1') {
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        width = grid[0].length;
        height = grid.length;
        Stack<Point> stack = new Stack<>();
        int cnt = 1;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < height; x++) {
                char g = grid[y][x];
                if (g == '1') {
                    bfs(grid, new Point(x,y), ++cnt);
                    System.out.println(Arrays.deepToString(grid));
                }
            }
        }
        return cnt-1;

    }
}

package com.splabs.leet.Graphs;

import java.util.Objects;
import java.util.Stack;

/*
There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
 */
public class LastDayToCross {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) return false;
            if (this == obj) return true;
            Point other = (Point)obj;
            return x==other.x && y==other.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
        @Override
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
    }
    int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
    private boolean isPath(int[][] grid, Point start) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Stack<Point> stack = new Stack<>();
        if (grid[start.y][start.x] == 0) {
            stack.push(start);
        }
        while(!stack.isEmpty()) {
            Point curr = stack.pop();
            visited[curr.y][curr.x] = true;
            if (curr.y == rows -1) {
                return true;
            }
            for(int i = 0; i< 4; i++) {
                int nx = curr.x + dirs[i][0];
                int ny = curr.y + dirs[i][1];
                if (nx >= 0 && ny >= 0 && nx < cols && ny < rows && !visited[ny][nx] && grid[ny][nx] == 0) {
                    stack.push(new Point(nx, ny));
                }
            }
        }
        return false;
    }
    private int[][] buildGrid(int row, int col, int[][] cells, int mid) {
        int[][] grid = new int[row][col];
        for(int c = 0; c <= mid; c++) {
            int[] cell = cells[c];
            grid[cell[0]-1][cell[1]-1] = 1;
        }
        return grid;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int last = -1;
        int low = 0;
        int high = cells.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (canCross(row, col, cells, mid)) {
                last = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last + 1;
    }
    private boolean canCross(int row, int col, int[][] cells, int mid) {
        var grid = buildGrid(row, col, cells, mid);
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                if (isPath(grid, new Point(c, 0))) {
                    return true;
                }
            }
        }
        return false;
    }
}

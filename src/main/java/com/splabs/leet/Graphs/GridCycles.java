package com.splabs.leet.Graphs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

/*
Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.

Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

Return true if any cycle of the same value exists in grid, otherwise, return false.
 */
public class GridCycles {
    static class Point {
        public int x;
        public int y;
        public Point parent = null;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // Same reference
            if (obj == null || getClass() != obj.getClass()) return false; // Type check
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
    }
    HashSet<Point> visited = new HashSet<>();

    int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1 ,0}};
    private boolean isCycle(char[][] grid, Point start) {
        char c = grid[start.y][start.x];
        var stack = new Stack<Point>();
        stack.push(start);
        Point next, curr = null, prev;
        int nx, ny;
        boolean canMove;
        while(!stack.empty()) {
            curr = stack.pop();
            prev = curr.parent;
            visited.add(curr);
            for(int i = 0; i < 4; i++) {
                nx = curr.x + dirs[i][0];
                ny = curr.y + dirs[i][1];

                if (nx < 0 || ny < 0 || nx >= grid[0].length || ny >= grid.length) {
                    continue;
                }
                if (grid[ny][nx] != c) {
                    continue;
                }

                if (prev != null && nx == prev.x && ny == prev.y) {
                    continue;
                }

                next = new Point(nx, ny, curr);

                if (visited.contains(next)) {
                    return true;
                }

                stack.push(next);
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x < grid[0].length; x++) {
                System.out.printf("(%d %d:%c)", x, y, grid[y][x]);
                var p = new Point(x, y);
                if(!visited.contains(p)) {
                    if (isCycle(grid, p)) {
                        return true;
                    }
                }
            }
            System.out.println();
        }
        return false;
    }
}

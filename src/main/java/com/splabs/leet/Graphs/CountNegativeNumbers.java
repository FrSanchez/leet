package com.splabs.leet.Graphs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 */
public class CountNegativeNumbers {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) return false;
            if (this == obj) return true;
            Point other = (Point)obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
    int [][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1 ,0}};

    public int countNegatives(int[][] grid) {
        int m = grid[0].length - 1; // cols
        int n = grid.length - 1; // rows
        boolean[][] visited = new boolean[n + 1][m + 1];
        Queue<Point> queue = new LinkedList<Point>();
        int count = 0;
        Point curr = null;
        if (grid[n][m] < 0) {
            queue.add(new Point(m, n));
        }
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (visited[curr.y][curr.x]) {
                continue;
            }
            visited[curr.y][curr.x] = true;
            count++;
            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dirs[i][0];
                int ny = curr.y + dirs[i][1];
                if (nx >= 0 && ny >= 0 && nx <= m && ny <= n) {
                    if (!visited[ny][nx] && grid[ny][nx] < 0) {
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        return count;
    }
}

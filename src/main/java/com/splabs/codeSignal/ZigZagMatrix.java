package com.splabs.codeSignal;

import java.util.*;

public class ZigZagMatrix {
    private static class Point {
        int r;
        int c;
        Point(int x, int y) {
            this.r = x;
            this.c = y;
        }
    }
    private final int[][] dirs = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public List<Integer> traverse(int[][] matrix) {
        var answer = new ArrayList<Integer>();
        // Do a BFS traversal
        var stack = new Stack<Point>();
        var visited = new boolean[matrix.length][matrix[0].length];
        stack.push(new Point(0, 0));
        while (!stack.isEmpty()) {
            var p = stack.pop();
            answer.add(matrix[p.r][p.c]);
            if(visited[p.r][p.c]) {
                continue;
            }
            visited[p.r][p.c] = true;
            System.out.printf("%d %d %d\n", p.r, p.c, matrix[p.r][p.c]);
            for (int[] dir : dirs) {
                int r = p.r + dir[0];
                int c = p.c + dir[1];
                if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && !visited[r][c]) {
                    stack.push(new Point(r, c));
                    break;
                }
            }
        }
        return answer;
    }
}

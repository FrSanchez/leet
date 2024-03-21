package com.splabs.lib;

import java.util.Arrays;
import java.util.Stack;

public class Islands {
    private static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int width;
    private int height;
    private void dfs(char[][] map, int sx, int sy, int num) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(sx, sy));
        while(!stack.empty()) {
            Point curr = stack.pop();
            map[curr.y][curr.x] = (char)('0' + num);
            for(int[] dir : dirs) {
                int dx = dir[0];
                int dy = dir[1];
                int nx = curr.x + dx;
                int ny = curr.y + dy;
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && map[ny][nx] == '#') {
                    stack.push(new Point(nx, ny));
                }
            }
        }
    }

    public void print(char[][] map) {
        for(char[] line : map) {
            System.out.println(Arrays.toString(line));
        }
    }
    public int count(char[][] map) {
        height = map.length;
        width =map[0].length;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(0, 0));
        int count = 0;
        while (!stack.empty()) {
            Point curr = stack.pop();
            int cx = curr.x;
            int cy = curr.y;
            if (map[cy][cx] == '#') {
                dfs(map, cx, cy, count++);
            }
            if (map[cy][cx] == '.') {
                map[cy][cx] = ':';
            }
            for(int[] dir : dirs) {
                int dx = dir[0];
                int dy = dir[1];
                int nx = cx + dx;
                int ny = cy + dy;
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    if (map[ny][nx] == '.' || map[ny][nx] == '#') {
                        stack.push(new Point(nx, ny));
                    }
                }
            }
        }
        return count;
    }
}

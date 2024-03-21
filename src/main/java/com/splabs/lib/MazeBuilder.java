package com.splabs.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeBuilder {

    private static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this(0,0);
        }
    }
    private static void init(char[][] maze) {
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j<  maze[i].length; j++) {
                maze[i][j] = '#';
            }
        }
    }
    public static void build(char[][] maze) {
        Random rnd = new Random();
        int height = maze.length;;
        int width = maze[0].length;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(0, 1));
        stack.push(new Point(1,1));
        init(maze);
        while (!stack.empty()) {
            Point curr = stack.pop();
            maze[curr.y][curr.x] = '.';
            List<int[]> valid = new ArrayList<>();
            // start in a random dir, not always on 0
            int r = rnd.nextInt(4);
            for(int i = 0; i < 4; i++) {
                int[] dir = dirs[(r + i) % 4];
                int dx = dir[0];
                int dy = dir[1];
                int x = curr.x + dx * 2;
                int y = curr.y + dy * 2;
                if (x > 0 && y > 0 && x < width && y < height && maze[y][x] == '#') {
                    valid.add(dir);
                }
            }
            if (!valid.isEmpty()) {
                int[] dir = valid.get(rnd.nextInt(valid.size()));
                int dx = dir[0];
                int dy = dir[1];
                stack.push(new Point(curr.x, curr.y));
                int nx = curr.x + dx;
                int ny = curr.y + dy;
                maze[ny][nx] = '.';
                nx += dx;
                ny += dy;
                stack.push(new Point(nx, ny));
            }
        }
        maze[height - 2][width - 1] = '.';
    }

    public static void print(char[][] maze) {
        for(int i = 0; i < maze.length; i++) {
            StringBuilder line = new StringBuilder();
            for(int j = 0; j<  maze[i].length; j++) {
                line.append(maze[i][j]);
            }
            System.out.println(line.toString());
        }
    }
}

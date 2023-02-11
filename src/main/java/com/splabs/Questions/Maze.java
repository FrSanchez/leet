package com.splabs.Questions;

import java.util.*;

public class Maze {

    int[][] dirs = {{1, 0}, { 0, 1}, {-1,0}, {0, -1} };
    Set<Integer> visited = new HashSet<>();
    private int toPoint(int x, int y, int width) {
        return y * width + x;
    }
    Random rand = new Random();
    public void printMaze(char[][] maze) {
        for(int r = 0; r < maze.length; r++) {
            for(int c = 0; c < maze[r].length; c++) {
                System.out.printf("%c ", maze[r][c]);
            }
            System.out.println();
        }
    }

    public char[][] initMaze(int width, int height) {
        char[][] maze = new char[height][width];
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze[y][x] = '#';
//                if (y % 2 == 1 && x % 2 == 0) {
//                    visited.add(toPoint(x,y,width));
//                }
            }
        }
        return maze;
    }

    public char[][] naiveMaze(int width, int height) {
        visited.clear();
        char[][] maze = initMaze(width, height);
        Stack<Integer> stx = new Stack<>();
        Stack<Integer> sty = new Stack<>();
        int sx = 0;
        int sy = 0;
        int ex = width - 1;
        int ey = height - 1;
        visited.add(toPoint(sx, sy, width));
        stx.add(sx);
        sty.add(sy);
        while (!stx.isEmpty()) {
            int x = stx.pop();
            int y = sty.pop();
            if (x==ex && y == ey) {
                break;
            }

            List<Integer> unvx = new ArrayList<>(4);
            List<Integer> unvy = new ArrayList<>(4);
            for (int c = 0; c < dirs.length; c++) {
                int nx = x + dirs[c][0];
                int ny = y + dirs[c][1];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    if (!visited.contains(toPoint(nx, ny, width))) {
                        unvx.add(nx);
                        unvy.add(ny);
                    }
                }
            }
            if (unvx.size() > 0) {
                int ran = rand.nextInt(unvx.size());
                int nx = unvx.get(ran);
                int ny = unvy.get(ran);
                stx.add(x);
                sty.add(y);
                stx.add(nx);
                sty.add(ny);
                maze[ny][nx] = '.';
                visited.add(toPoint(nx, ny, width));
            }
        }
        return maze;
    }

    public char[][] generateMaze(int width, int height) {
        char[][] maze = initMaze(width, height);
        int sx = 0;
        int sy = rand.nextInt(height);
        int ex = width-1;
        int ey = rand.nextInt(height);
        maze[sy][sx] = '.';

        Stack<Integer> stx = new Stack<>();
        Stack<Integer> sty = new Stack<>();
        stx.add(sx);
        sty.add(sy);
        while(!stx.isEmpty()) {
            int x = stx.pop();
            int y = sty.pop();
            if (x == ex && y == ey) {
                break;
            }
            if (!visited.contains(toPoint(x, y, width))) {
                visited.add(toPoint(x, y, width));
                maze[y][x] = '.';
                int dir = rand.nextInt(dirs.length);
                for(int c = 0; c < dirs.length; c++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (nx >= 0 && ny >= 0 && nx < width && ny < height){
                        if (!visited.contains(toPoint(nx, ny, width))) {
                            stx.add(nx);
                            sty.add(ny);
                        }
                    }
                    dir = (dir+1) % dirs.length;
                }
            }

        }
        maze[ey][ex] = 'E';
        maze[sy][sx] = 'S';
        return maze;
    }

    public char[][] getMaze(int width, int height) {

        width = width*2+1;
        height = height*2+1;
        char[][] maze = initMaze(width, height);
        int sx = 1;
        int sy = 1;
        int ex = width - 2;
        int ey = width - 2;

        Stack<Integer> stx = new Stack<>();
        Stack<Integer> sty = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stx.add(sx);
        sty.add(sy);
        while(!stx.isEmpty()) {
            int x = stx.pop();
            int y = sty.pop();
            if (x == ex && y == ey) {
//                break;
            }
            visited.add(toPoint(x, y, width));
            maze[y][x] = ' ';
            List<Integer> toX = new ArrayList<>(dirs.length);
            List<Integer> toY = new ArrayList<>(dirs.length);
            List<Integer> toDir = new ArrayList<>(dirs.length);
            for(int i = 0; i < dirs.length; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                int nx2 = nx + dirs[i][0];
                int ny2 = ny + dirs[i][1];
                if (nx >0 && ny > 0 && nx < width -1 && ny < height -1
                        &&  !visited.contains(toPoint(nx2, ny2, width))) {
                    toX.add(nx);
                    toY.add(ny);
                    toDir.add(i);
                }
            }
            if (toX.size() > 0) {
                stx.add(x);
                sty.add(y);
                int i = rand.nextInt(toX.size());
                int nx = toX.get(i);
                int ny = toY.get(i);
                int dir = toDir.get(i);
                visited.add(toPoint(nx, ny, width));
                maze[ny][nx] = ' ';
                nx += dirs[dir][0];
                ny += dirs[dir][1];
                visited.add(toPoint(nx, ny, width));
                stx.add(nx);
                sty.add(ny);
            }
        }
        maze[1][0] = ' ';
        maze[height - 2][width - 1] = ' ';
        return maze;
    }
}

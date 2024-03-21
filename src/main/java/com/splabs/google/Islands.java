package com.splabs.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Islands {

    private int[][] directions = { {-1,0}, {1, 0}, {0, -1}, {0, 1}};

    private void fillOcean(int[][] map, int sx, int sy, int value) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(sx,sy));
        while(!stack.isEmpty()) {
            Point curr = stack.pop();
            map[curr.getY()][curr.getX()] = value; // ocean
            for(int i = 0; i < 4; i++) {
                int x = curr.getX() + directions[i][0];
                int y = curr.getY() + directions[i][1];
                if (x >=0 && y>=0 && y < map.length && x < map[0].length) {
                    if (map[y][x] == 0) {
                        stack.push(new Point(x,y));
                    }
                }
            }
        }
    }

    private void outMap(int[][] map) {
        for(int y = 0; y < map.length; y++) {
            System.out.print("{");
            for(int x = 0; x < map[y].length; x++) {
                System.out.printf(" %3d", map[y][x]);
            }
            System.out.println(" }");
        }
    }

    public int findWQueue(int[][] map, int startX, int startY) {
        int height = map.length;
        if (height < 1) {
            return 0;
        }
        int width = map[0].length;
        for(int i = 0; i < width; i++) {
            if (map[0][i] == 0) {
                fillOcean(map, i, 0, -2);
                break;
            }
        }
        outMap(map);
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(startX, startY));
        int count = 0;
        while (!stack.isEmpty()) {
            Point curr = stack.pop();
            map[curr.getY()][curr.getX()] = 2;
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <=1; j++) {
                    int x = curr.getX() + i;
                    int y = curr.getY() + j;
                    if (x==0 && y ==0) {
                        continue;
                    }
                    if (x >= 0 && y >=0 && x < width && y < height) {
                        if (map[y][x] == 1) {
                            stack.add(new Point(x, y));
                        }
                        if (map[y][x] == 0) {
                            count++;
                            fillOcean(map, x, y, count * 10);
                        }
                    }
                }
            }
        }
        outMap(map);
        return count;
    }

    public void findIslands(int[][] map, int startX, int startY) {
        if (map[startY][startX] == 0) {
            System.out.println("Not in land!");
        }
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        Point last = null;
        queue.add(new Point(startX, startY, null));
        while (!queue.isEmpty()) {
            Point current = queue.remove();
            // System.out.print(current);
            // System.out.print(visited);
            if (!visited.contains(current)) {
                System.out.print(current);
                visited.add(current);
                for(int i = -1; i <= 1; i++) {
                    for (int j = -1; j <=1; j++) {
                        int X = i + current.getX();
                        int Y = j + current.getY();
                        if(i == 0 && j == 0) {
                            continue;
                        }
                        if (X >= 0 && Y >= 0 && X < map[0].length && Y < map.length) {
                            if (map[Y][X] == 1) {
                                if (last != null && (X == last.getX() && Y == last.getY())) {
                                    continue;
                                }
                                Point p = new Point(X, Y, current);
                                queue.add( p );
                            
                            }
                        }
                    }
                }
                last = current;
            } else {
                System.out.println(current);
                System.out.println(visited);
                return;
            }
        }
        return;
    }
}

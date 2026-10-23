package com.splabs.leet.Graphs;

import java.util.*;

public class SafePath {
    private int n, m;

    private static class Point {
        public int x = 0, y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // right, down, left, up
        n = grid.size(); // height
        m = grid.get(0).size(); // width
        if (m == 0 || n == 0) {
            return false;
        }
        Stack<Point> stack = new Stack<>();
        Set<Point> vis = new HashSet<>();
        stack.push(new Point(0, 0));
        while (!stack.empty()) {
            System.out.println(stack);
            System.out.println(vis);
            Point curr = stack.pop();
            if (vis.contains(curr)) {
                continue;
            }
            System.out.printf("Now visiting %s\n", curr);
            vis.add(curr);
            int vc = grid.get(curr.y).get(curr.x);
            boolean out = false;
            for (int[] dir : dirs) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int v = grid.get(ny).get(nx);
                    if (nx == m && ny == n) {
                        if (v == 0) {
                            return true;
                        }
                        if (v == 1 && health > 0) {
                            return true;
                        }
                        return false;
                    }
                    var p = new Point(nx, ny);
                    if (v == 0 && !vis.contains(p)) {
                        System.out.printf("%s(%d)->%s(%d)\n", curr, vc, p, v);
                        stack.push(p);
                        out = true;
                    }
                }
            }
            if (!out && health > 0) {
                System.out.println("how to choose an exit now?");
            }
        }
        return false;
    }

}

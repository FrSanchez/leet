package com.splabs.lib;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class DynamicTimeWarping {

    public static class Point implements Comparable<Point> {
        private int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() { return x; }
        int getY() { return y; }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point rhs = (Point)obj;
                return x == rhs.x && y == rhs.y;
            }
            return false;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) {
                return x - o.x;
            }
            return y - o.y;
        }
    }


    public int calculatePath(int [] p, int [] q) {
        Integer[][] matrix = new Integer[p.length][q.length];
        int[][] dirs = {{0,-1}, {-1,0}, {-1,-1}}; // right, up, diag
        for(int i = 0; i < p.length; i++) {
            for(int j = 0; j < q.length; j++) {
                matrix[i][j] = Math.abs(p[i] - q[j]);
                int minCost = Integer.MAX_VALUE;
                for(int[] dir : dirs) {
                    if (i + dir[0] >= 0 && j + dir[1] >= 0) {
                        int c = matrix[i + dir[0]][j + dir[1]];
                        if (c < minCost) {
                            minCost = c;
                        }
                    }
                }
                if(minCost < Integer.MAX_VALUE) {
                    matrix[i][j] += minCost;
                }
            }
            printMatrix(matrix, 0);
        }
        printMatrix(matrix, 0);
        Point curr = new Point(p.length-1, q.length-1);
        Stack<Point> path = new Stack<>();
        Point next = null;
        while(!curr.equals(new Point(0,0 ))) {
            path.push(curr);
            int minVal = matrix[curr.getX()][curr.getY()];
            Point temp = curr;
            for(int[] dir: dirs) {
                next = new Point(curr.getX() + dir[0], curr.getY() + dir[1]);
                // find the min value in the adjacent and diagonal cells
                if (next.getX() >= 0 && next.getY() >= 0) {
                    int c = matrix[next.getX()][next.getY()];
                    if (c <= minVal) {
                        temp = next;
                        minVal = c;
                    }
                }
            }
            curr = temp;
        }
        if (next != null) {
            path.push(new Point(0,0));
        }
        while(!path.empty()) {
            var pnt = path.pop();
            System.out.printf("(%d, %d) = %d ", pnt.getX(), pnt.getY(), matrix[pnt.getX()][pnt.getY()]);
        }
        System.out.println();

        return matrix[p.length-1][q.length-1];
    }

    private void printMatrix(Integer[][] matrix, int cost) {
        for(int i = matrix.length -1 ; i >= 0; i--) {
            Integer[] line = matrix[i];
            for(Integer c : line) {
                System.out.printf("%3d ", c);
            }
            System.out.println();
        }
        System.out.printf("---------------------------------------- %d%n", cost);
    }

}

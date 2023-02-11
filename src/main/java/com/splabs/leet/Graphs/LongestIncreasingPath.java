package com.splabs.leet.Graphs;

import java.util.*;

public class LongestIncreasingPath {
    int height;
    int width;

    int[][] matrix;

    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    int[] toXY(int point) {
        int x = point % width;
        int y = point / width;
        return new int[] {x,y};
    }

    private int dfsUpDown(int at, Set<Integer> visited, int len, Set<Integer> path, boolean upDown) {
        visited.add(at);
        path.add(at);
        int[] xy = toXY(at);
        boolean leaf = true;
        int max = len + 1;
        for (int[] dir : dirs) {
            int nx = xy[0] + dir[0];
            int ny = xy[1] + dir[1];
            int npt = toPoint(nx, ny);
            try {
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visited.contains(npt)) {
                    if ((upDown && matrix[ny][nx] > matrix[xy[1]][xy[0]]) ||
                            (!upDown && matrix[ny][nx] < matrix[xy[1]][xy[0]])) {
                        int nl = dfsUpDown(npt, visited, len + 1, path, upDown);
                        if (nl > max) {
                            max = nl;
                        }
                        leaf = false;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
                System.err.printf("xy: %d,%d nx,ny: %d,%d at:%d npt:%d\n", xy[0], xy[1], nx, ny, at, npt);
            }
        }
        if (leaf) {
//            System.out.println(path);
        }
        visited.remove(at);
        return max;
    }

    public int longestIncreasingPathOld(int[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        if (0 == height) {
            return 0;
        }
        width = matrix[0].length;
        if (width == 0) {
            return 0;
        }
        int maxL = 1;
        Set<Integer> visited = new HashSet<>();
        int size = width * height;
        for(int pt = 0; pt < size; pt++) {
            if (!visited.contains(pt)) {
                Set<Integer> path = new TreeSet<>();
                int len = dfsUpDown(pt, visited, 0, path, true);
                len = dfsUpDown(pt, visited, len - 1, path, false);
                if (len > maxL) {
                    maxL = len;
                }
            }
        }
        return maxL;
    }

    int toPoint(int x, int y) {
        return x + y * width;
    }


    public int longestIncreasingPath(int[][] matrix) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int[][] memo = new int[ROW][COL];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                int currMax = dfs(matrix, i, j, -1, memo);
                max = Math.max(max, currMax);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int previous, int[][] memo) {
        if(previous >= matrix[i][j]) return 0;
        if(memo[i][j] != 0) return memo[i][j];


        int curr = matrix[i][j];
        int [] len = {0,0,0,0};
        int di = 0;
        for(int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >=0 && nj >= 0 && ni < matrix.length && nj < matrix[ni].length) {
                len[di++] = dfs(matrix, ni, nj, curr, memo);
            }
        }

        int max = len[0];
        for(int mi = 1; mi < 4; mi++) {
            max = Integer.max(max, len[mi]);
        }
        memo[i][j] = max + 1;
        return memo[i][j];
    }
}

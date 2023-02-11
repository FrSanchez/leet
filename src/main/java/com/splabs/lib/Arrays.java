package com.splabs.lib;

public class Arrays {
    public int[][] spiral(int n) {
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int[][] ans = new int[n][n];
        int sx = 0;
        int sy = 0;
        int dir = 0;
        int len = n * n;
        for(int i = 1; i <= len; i++) {
            ans[sy][sx] = i;
            int nx = sx + dirs[dir][0];
            int ny = sy + dirs[dir][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || ans[ny][nx] != 0) {
                dir = (dir +1 ) %4;
            }
            sx += dirs[dir][0];
            sy += dirs[dir][1];
        }
        return ans;
    }
}

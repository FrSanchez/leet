package com.splabs.Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class MineSweeper {

    private class Pair {
        public int x, y;

        public Pair(int x, int y) {
            this.x = x; 
            this.y = y;
        }
    }
    /**
     * @param field
     * @param x
     * @param y
     * @return
     */
    public int[][] calculateField(boolean[][] field, int x, int y) 
    {
        final Queue<Pair> queue = new LinkedList<>();
        
        int[][] ans = new int[field.length][field[0].length];
        for(int j=0; j < field.length; j++) {
            Arrays.fill(ans[j], -1);
        }
        ans[y][x] = calculateBombs(field, x, y);
        if (ans[y][x] == 0) {
            queue.add(new Pair(x,y));
        }

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            for(int i = x -1; x <= x + 1; i++) {
                for (int j = y -1; y <= y +1; y++) {
                    if (i >= 0 && j >= 0 && i < field[0].length && j < field.length) {
                        if (! (i==x && j==y)) {
                            ans[j][i] = calculateBombs(field, i, j);
                        }
                    }
                }
            }
            }
        return ans;
    }

    private int calculateBombs(boolean[][] field, int x, int y) {
        int sum = 0;
        for(int i = x -1; x <= x + 1; i++) {
            for (int j = y -1; y <= y +1; y++) {
                if (i >= 0 && j >= 0 && i < field[0].length && j < field.length) {
                    sum += field[j][i] ? 1 : 0;
                }
            }
        }
        return sum;
    }
    
}

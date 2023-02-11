package com.splabs.udemy;

import java.util.*;

public class Dungeon {
    Queue<Integer> rq = new LinkedList<>(); // empty row queue
    Queue<Integer> cq = new LinkedList<>(); // empty column queue
    // north, south, east, west direction vectors
    int [] dr = { -1, 1, 0,  0};
    int [] dc = {  0, 0, 1, -1};
    int [][] maze;
    boolean [][] visited;

    int nodesLeftInLayer;
    int nodesInNextLayer;

    /**
     * The goal is to find the shortest path from start to exit
     *
     * @param maze a 2D matrix representing the mze
     *             A . means the block is empty
     *             A # means the block is occupied by a boulder
     * @param sc    Start Column
     * @param sr    Start Row
     */
    public int findExit(int[][] maze, int sc, int sr) {
        this.maze = maze;
        int R = maze.length;
        int C = maze[0].length;

        // RxC matrix of false values used to track whether the
        // node at position (i, j) has been visited
        visited = new boolean[maze.length][maze[0].length];
        for(int r = 0; r < maze.length; r++) {
            Arrays.fill(visited[r], false);
        }

        cq.clear();
        rq.clear();
        return solve(maze, sr, sc, visited);
    }

    private int solve(int[][] maze, int sr, int sc, boolean[][] visited) {
        // variables used to track the number of steps taken
        int moveCount = 0;
        nodesLeftInLayer=1;
        nodesInNextLayer=0;

        // variable used to track whether the E character ever gets reached during the BFS
        boolean reachedEnd = false;

        rq.add(sr);
        cq.add(sc);
        visited[sr][sc] = true;
        while (!rq.isEmpty()) {
            System.out.println(rq);
            System.out.println(cq);
            int r = rq.poll();
            int c = cq.poll();
            if (maze[r][c] == 'E') {
                reachedEnd = true;
                break;
            }
            exploreNeighbours(r,c, maze.length, maze[0].length);
            nodesLeftInLayer--;
            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }
        if (reachedEnd) {
            return moveCount;
        }
        return -1;
    }

    private void exploreNeighbours(int r, int c, int R, int C) {
        for(int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];

            if (rr >= 0 && rr < R && cc >= 0 && cc < C) {
                if (visited[rr][cc]) {
                    continue;
                }
                if (this.maze[rr][cc] == '#') {
                    continue;
                }

                rq.add(rr);
                cq.add(cc);
                visited[rr][cc] = true;
                nodesInNextLayer++;
            }
        }
    }
}

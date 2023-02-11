package com.splabs.Questions;

import org.junit.jupiter.api.Test;

public class MazeTest {
    @Test
    public void testSimple()
    {
        Maze maze = new Maze();
        char[][] mz = maze.generateMaze(10, 10);
        maze.printMaze(mz);
    }

    @Test
    public void testNaive() {
        Maze maze = new Maze();
        char[][] mz = maze.naiveMaze(10, 10);
        maze.printMaze(mz);
    }

    @Test
    public void testInit() {
        Maze maze = new Maze();
        char[][] mz = maze.initMaze(5, 5);
        maze.printMaze(mz);
    }

    @Test
    public void largerMaze() {
        Maze algo = new Maze();
        char[][] maze = algo.getMaze(10, 6);
        algo.printMaze(maze);
    }
}

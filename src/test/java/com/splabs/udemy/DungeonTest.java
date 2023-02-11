package com.splabs.udemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DungeonTest {
    @Test
    public void findExitTest() {
        Dungeon d = new Dungeon();
        int[][] maze = {
                {'.','.','.','#','.','.','.'},
                {'.','#','.','.','.','#','.'},
                {'.','#','.','.','.','.','.'},
                {'.','.','#','#','.','.','.'},
                {'#','.','#','E','.','#','.'},
        };
        int moves = d.findExit(maze, 0, 0);
        assertEquals(9, moves);
    }
}

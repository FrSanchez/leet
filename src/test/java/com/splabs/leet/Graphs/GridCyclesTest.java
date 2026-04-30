package com.splabs.leet.Graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridCyclesTest {
    @Test
    public void Case3() {
        char[][] grid = {
                {'a','b','b'},
                {'b','z','b'},
                {'b','b','a'}};

        GridCycles gc = new GridCycles();
        Assertions.assertFalse(gc.containsCycle(grid));
    }

    @Test
    public void Case4() {
        char[][] grid = {
                {'c', 'a', 'd'},
                {'a', 'a', 'a'},
                {'a', 'a', 'd'},
                {'a', 'c', 'd'},
                {'a', 'b', 'c'}};

        GridCycles gc = new GridCycles();
        Assertions.assertTrue(gc.containsCycle(grid));
    }

    @Test
    public void Case5() {
        char[][] grid = {
                {'b', 'a', 'c'},
                {'c', 'a', 'c'},
                {'d', 'd', 'c'},
                {'b', 'c', 'c'}};

        GridCycles gc = new GridCycles();
        Assertions.assertFalse(gc.containsCycle(grid));
    }

    @Test
    public void Case6() {
        char[][] grid = {
                {'d','b','b'},
                {'c','a','a'},
                {'b','a','c'},
                {'c','c','c'},
                {'d','d','a'}};

        GridCycles gc = new GridCycles();
        Assertions.assertFalse(gc.containsCycle(grid));
    }
}

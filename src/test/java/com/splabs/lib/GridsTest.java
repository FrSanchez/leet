package com.splabs.lib;

import org.junit.jupiter.api.Test;

public class GridsTest {
    @Test
    public void testGrid() {
        Grids grids = new Grids();
        int[][] arr = {
                {0,0,1},
                {0,0,0},
                {0,0,0}
        };
        int s = grids.findPaths(arr);
        System.out.println(s);
    }

    @Test
    public void testPrintPaths() {
        Grids grids = new Grids();
        int[][] arr = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int c = grids.printAllPaths(arr, 0, 0, 2, 2);
        System.out.printf("Paths: %d\n", c);
        arr = new int[][]{
                {0, 0, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        c =grids.printAllPaths(arr, 0, 0, 2, 2);
        System.out.printf("Paths: %d\n", c);
    }

    @Test
    public void testCount() {
        Grids grids = new Grids();
        int[][] arr = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int c = grids.countPaths(arr, 0, 0, 2, 2);
        System.out.printf("Paths: %d\n", c);

        arr = new int[][]{
                {0, 0, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        c = grids.countPaths(arr, 0, 0, 2, 2);
        System.out.printf("Paths: %d\n", c);
    }
}

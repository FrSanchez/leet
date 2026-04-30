package com.splabs.leet.Graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountNegativeNumbersTest {
    @Test
    public void Test() {
        System.out.printf("%d %% %d = %d\n ", 5, 2, 5%2);
        System.out.printf("%d %% %d = %d\n ", 2, 5, 2%5);
        System.out.printf("%d %% %d = %d\n ", 3, 4, 3%4);
        System.out.printf("%d %% %d = %d\n ", 14, 3, 14%3);
    }
    @Test
    public void Case1() {
        int[][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        CountNegativeNumbers cn = new CountNegativeNumbers();
        int c = cn.countNegatives(grid);
        Assertions.assertEquals(8, c);
    }
}

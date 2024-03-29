package com.splabs.HackerRank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Arrays2DTest {
    @Test
    public void testHourGlass() {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0)
        );
        Arrays2D.hourglassSum(arr);
    }

    @Test
    public void test2() {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(-1, 1, -1, 0, 0, 0),
                Arrays.asList(0, -1, 0, 0, 0, 0),
                Arrays.asList(-1, -1, -1, 0, 0, 0),
                Arrays.asList(0, -9, 2, -4, -4, 0),
                Arrays.asList(-7, 0, 0, -2, 0, 0),
                Arrays.asList(0, 0, -1, -2, -4, 0));
        int sum = Arrays2D.hourglassSum(arr);
        assertEquals(0, sum);
        StringBuilder sb = new StringBuilder();
    }

    @Test
    public void rotat1() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        Arrays2D.rotateLeft(4, arr);
    }
}

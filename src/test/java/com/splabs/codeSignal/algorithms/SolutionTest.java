package com.splabs.codeSignal.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    SumIndicesArrays sol = new SumIndicesArrays();

    @Test
    public void testBasicMatch() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int target = 7;
        assertArrayEquals(new int[]{1}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testNoMatch() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int target = 10;
        assertArrayEquals(new int[]{}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr1 = {-5, -3, 2, 4};
        int[] arr2 = {10, 6, -2, -1};
        int target = 5;
        assertArrayEquals(new int[]{0}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testMixedSigns() {
        int[] arr1 = {0, -2, 5, 3};
        int[] arr2 = {5, 2, -1, 6};
        int target = 5;
        assertArrayEquals(new int[]{0}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testSingleElementMatch() {
        int[] arr1 = {3};
        int[] arr2 = {7};
        int target = 10;
        assertArrayEquals(new int[]{0}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testEmptyArrays() {
        int[] arr1 = {};
        int[] arr2 = {};
        int target = 0;
        assertArrayEquals(new int[]{}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testLargeNumbers() {
        int[] arr1 = {100000, -1000000};
        int[] arr2 = {-100000, 1000000};
        int target = 0;
        assertArrayEquals(new int[]{0,1}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testAllZeros() {
        int[] arr1 = {0, 0, 0};
        int[] arr2 = {0, 0, 0};
        int target = 0;
        assertArrayEquals(new int[]{0, 1, 2}, sol.solution(arr1, arr2, target));
    }

    @Test
    public void testLargeInputPerformance() {
        int[] arr1 = new int[1_000_000];
        int[] arr2 = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            arr1[i] = 1;
            arr2[i] = 2;
        }
        int target = 3;
        int[] expected = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            expected[i] = i;
        }
        assertArrayEquals(expected, sol.solution(arr1, arr2, target));
    }
}

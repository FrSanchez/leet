package com.splabs.codeSignal.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumIndicesTest {

    SumIndices service = new SumIndices();

    @Test
    public void testExampleCase() {
        int[] arrA = {2, 5, 1, 4};
        int[] arrB = {3, 6, 3, 2};
        int[] result = service.findIndices(arrA, arrB);
        assertArrayEquals(new int[]{2, 3}, result);
    }

    @Test
    public void testMinimalCase() {
        int[] arrA = {1, 2};
        int[] arrB = {2, 1};
        int[] result = service.findIndices(arrA, arrB);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testNegativeNumbers() {
        int[] arrA = {-1, -2, 3};
        int[] arrB = {0, -3, 2};
        int[] result = service.findIndices(arrA, arrB);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testMultipleValidPairs() {
        int[] arrA = {1, 2, 3, 4};
        int[] arrB = {2, 1, 4, 3};
        int[] result = service.findIndices(arrA, arrB);
        assertArrayEquals(new int[]{0, 1}, result); // minimal i, minimal j
    }

    @Test
    public void testLargeInputPerformance() {
        int n = 10000;
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = i;
            arrB[i] = i;
        }
        arrA[n - 2] = 100;
        arrA[n - 1] = 200;
        arrB[n - 2] = 150;
        arrB[n - 1] = 150;
        int[] result = service.findIndices(arrA, arrB);
        assertArrayEquals(new int[]{n - 2, n - 1}, result);
    }
}

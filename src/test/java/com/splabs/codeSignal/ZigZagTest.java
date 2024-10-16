package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagTest {
    @Test
    public void matrix3x4() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        var zz = new ZigZagMatrix();
        var actual = zz.traverse(matrix);
        assertEquals(new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)), actual);
    }

    @Test
    public void matrix1x1() {
        int[][] matrix = new int[][] {
                {1}
        };
        var zz = new ZigZagMatrix();
        var actual = zz.traverse(matrix);
        assertEquals(new ArrayList<>(Arrays.asList( 1)), actual);
    }
}

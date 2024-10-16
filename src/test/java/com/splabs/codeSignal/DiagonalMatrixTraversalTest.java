package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalMatrixTraversalTest {
    @Test
    public void testSample() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        var actual = DiagonalMatrixTraversal.diagonalTraverseAndSquares(matrix);
        assertEquals(new ArrayList<>(Arrays.asList( 1, 6, 9)), actual);
    }

    @Test
    public void testNegatives() {
        int[][] matrix = new int[][] {{1, -2, 3, -4},
                {5, -6, 7, 8},
                {-9, 10, -11, 12}};
        var actual = DiagonalMatrixTraversal.diagonalTraversalAndNegatives(matrix);
        int[][] expected = {{1, 2}, {3, 1}, {2, 2}, {1, 4}, {3, 3}};
        var list = new ArrayList<int[]>(Arrays.asList(expected));
        assertEquals(list.size(), actual.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i)[0], actual.get(i)[0]);
            assertEquals(list.get(i)[1], actual.get(i)[1]);
        }
    }
}

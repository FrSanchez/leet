package com.splabs.leet.Graphs;

import com.splabs.leet.Strings.ReverseParenthesis;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumXORPathTest {
    @ParameterizedTest
    @MethodSource("parenthesisProvider")
    public void test(int[][] grid, int expected) {
        var test = new MinimumXORPath();
        int actual = test.minCost(grid);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> parenthesisProvider() {
        return Stream.of(
                Arguments.of(new int[][] { { 1,2}, { 3, 4} }, 6),
                Arguments.of(new int[][] { { 6, 7}, { 5, 8} }, 9),
                Arguments.of(new int[][] { { 2, 7, 5} }, 0)
        );
    }
}

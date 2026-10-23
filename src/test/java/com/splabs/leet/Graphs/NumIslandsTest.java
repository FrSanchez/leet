package com.splabs.leet.Graphs;

import com.splabs.leet.Arrays.CanJump;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(char[][] grid, int expected) {
        var sol = new NumIslands();
        var actual = sol.numIslands(grid);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}, 1)
        );
    }
}

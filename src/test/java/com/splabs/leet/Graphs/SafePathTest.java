package com.splabs.leet.Graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SafePathTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(int[][] input, int health, boolean expected) {
        List<List<Integer>> list = new ArrayList<>();
        // transform input to list
        for(int i = 0; i < input.length; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < input[i].length; j++) {
                list.get(i).add(input[i][j]);
            }
        }
        var arrays = new SafePath();
        boolean actual = arrays.findSafeWalk(list, health);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}}, 1, true)
        );
    }
}

package com.splabs.google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IslandTest {
    private int[][] map;
    private Islands islands;
    @BeforeEach
    public void init() {
        map = new int[][] {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,1,1,1,0,0,0,1,0,1,0,0,1,0,0,0},
            {0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        islands = new Islands();
    }

    @ParameterizedTest
    @MethodSource("test1Provider")
    public void testCount(int x, int y, int count) {
        int c = islands.findWQueue(map, x, y);
        assertEquals(count, c);
    }
    @Test 
    public void test1(){
        islands.findIslands(map, 11, 3);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
            Arguments.of(2, 2, 0),
            Arguments.of(6, 6, 1),
            Arguments.of(12, 5, 2)
        );
    }

}

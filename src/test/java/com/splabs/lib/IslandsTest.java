package com.splabs.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandsTest {
    Islands islands;
    @BeforeEach
    public void init() {
        islands = new Islands();
    }

    @Test
    public void test() {
        char[][] map = {
                "##...#..........".toCharArray(),
                "....##..........".toCharArray(),
                ".....##.........".toCharArray(),
                ".........##.....".toCharArray(),
                "..........#.....".toCharArray(),
                "..........#...#.".toCharArray(),
        };
        int n = islands.count(map);
        islands.print(map);
        assertEquals(4, n);
    }
}

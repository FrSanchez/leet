package com.splabs.lib;

import org.junit.jupiter.api.Test;

public class MazeBuilderTest {
    @Test
    public void test() {
        char[][] maze = new char[11][21];
        MazeBuilder.build(maze);
        MazeBuilder.print(maze);
    }
}

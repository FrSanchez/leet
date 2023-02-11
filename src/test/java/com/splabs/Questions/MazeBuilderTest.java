package com.splabs.Questions;

import org.junit.jupiter.api.Test;

public class MazeBuilderTest {
    @Test
    public void testBuild() {
        MazeBuilder builder = new MazeBuilder();
        char[][] maze = builder.build(15,15);
        builder.print(maze);
    }
}

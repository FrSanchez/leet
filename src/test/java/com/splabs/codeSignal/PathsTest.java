package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathsTest {
    @Test
    public void testSample() {
        String [] paths = new String[]
                {
                        "/a/folder1/../folder1/a/leaf.txt",
                        "/b/folder2/../folder1/a/leaf.txt",
                        "/a/folder3/folder1/folder1/../a/leaf.txt",
                };
        var sol = new Paths();
        var actual = sol.commonSuffix(paths);
        assertEquals("/folder1/a/leaf.txt", actual);
    }
}

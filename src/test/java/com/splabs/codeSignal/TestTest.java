package com.splabs.codeSignal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void testCommonPaths(String[] paths, String expected) {

        Test t = new Test();

        String actual = t.commonPaths(paths);
        System.out.printf("%s == %s?\n", actual, expected);
        assertTrue(actual.compareTo(expected) == 0);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of(new String[] { "a/folder1/../folder1/a/leaf.txt", "b/folder2/../folder1/a/leaf.txt" },
                        "/folder1/a/leaf.txt"),
                Arguments.of(new String[] { "/root/folder1/b/../a", "/root/folder1/a/leaf",
                        "/root/folder1/a/b/../../a/branch" }, ""));
    }

    @ParameterizedTest
    @MethodSource("test2Provider")
    public void testServerPowers(int[] serverPowers, String[] events, int exp) {
        Test t = new Test();
        int actual = t.serverPowers(serverPowers, events);
        assertEquals(exp, actual);
    }

    static Stream<Arguments> test2Provider() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 1, 2, 1 }, new String[] {
                        "REQUEST",
                        "REQUEST",
                        "FAIL 2",
                        "REQUEST",
                        "FAIL 3",
                        "REQUEST",
                        "REQUEST"
                }, 1));
    }
}

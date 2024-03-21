package com.splabs.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathTest {
    Paths paths;
    @BeforeEach
    public void init() {
        paths = new Paths();
    }

    @ParameterizedTest
    @MethodSource("photoProvider")
    public void cdTest(String cwd, String arg, String expected) {
        String actual = paths.cd(cwd, arg);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> photoProvider() {
        return Stream.of(
                Arguments.of("/", "foo", "/foo"),
                Arguments.of("/baz", "/bar", "/bar"),
                Arguments.of("/x/y", "../a/b", "/x/a/b")
        );
    }
}

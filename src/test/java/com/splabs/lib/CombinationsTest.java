package com.splabs.lib;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.List;

public class CombinationsTest {
    @ParameterizedTest
    @MethodSource("removeKProvider")
    public void testAllStrings(String input)
    {
        Combinations c = new Combinations();
        List<String> combinations = c.allStrings(input);
        System.out.println(combinations);
    }

    static Stream<Arguments> removeKProvider() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("ab"),
                Arguments.of("abc"),
                Arguments.of("aabb")
        );
    }
}

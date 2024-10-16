package com.splabs.codeSignal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitWordsTest {
    @ParameterizedTest
    @MethodSource("splitProvider")
    public void testAllStrings(String s, char c, int n)
    {
        SplitWords sw = new SplitWords();
        var actual = sw.solution(s);
        assertEquals(c, actual.getKey());
        assertEquals(n, actual.getValue());
    }

    static Stream<Arguments> splitProvider() {
        return Stream.of(
                Arguments.of("Hello, world!", 'l', 2)

        );
    }

}

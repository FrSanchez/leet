package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstringKLengthTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(String test, int K, int exp)
    {
        var skl = new SubstringKLength();
        var actual = skl.solution(test, K);
        assertEquals(exp, actual);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of("acaabcc", 2, 4),
                Arguments.of("aaaaaaa", 1, 7),
                Arguments.of("abcabcabcabc", 3, 12),
                Arguments.of("abcabcabcabc", 2, 2),
                Arguments.of("AaAaAa", 1, 1),
                Arguments.of("1234567890", 10, 10),
                Arguments.of("", 1, 0),
                Arguments.of("abcabcabcabc", 4, 12)
        );
    }

}

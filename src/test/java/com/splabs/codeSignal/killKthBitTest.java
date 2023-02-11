package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class killKthBitTest {
    @ParameterizedTest
    @MethodSource("removeKProvider")
    public void testAllStrings(int n, int k, int o)
    {
        KIllKthBit kb = new KIllKthBit();
        int actual = kb.solution(n, k);
        assertEquals(o, actual);
    }

    static Stream<Arguments> removeKProvider() {
        return Stream.of(
                Arguments.of(37, 3, 33),
                Arguments.of(37, 4, 37),
                Arguments.of(37, 2, 37)

        );
    }

    @Test
    public void mirror() {
        KIllKthBit kb = new KIllKthBit();
        kb.mirrorBits(37);
    }
}

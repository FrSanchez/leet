package com.splabs.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackStabilizationTest {
    StackStabilization ss ;
    @BeforeEach
    public void init() {
        ss = new StackStabilization();

    }

    @ParameterizedTest
    @MethodSource("uniformProvider")
    public void count(int N, int[] R, int expected) {
        int a = ss.getMinimumDeflatedDiscCount(N, R);
        assertEquals(expected, a);
    }

    static Stream<Arguments> uniformProvider() {
        return Stream.of(
                Arguments.of(5, new int[] {2, 5, 3, 6, 5}, 3),
                Arguments.of(3, new int[] {100, 100, 100}, 2),
                Arguments.of(4, new int[] {6, 5, 4, 3}, -1)
        );
    }
}

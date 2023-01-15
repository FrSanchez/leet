package com.splabs.leet.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SequenceTest {
    
    @ParameterizedTest
    @MethodSource("sequenceProvider")
    void testSequence(int[] a, boolean answer) {
        Sequence s = new Sequence();
        assertEquals(answer,  s.solution(a));
    }

    static Stream<Arguments> sequenceProvider() {
        return Stream.of(
            Arguments.of(new int[] { 1, 2, 1, 2}, false),
            Arguments.of(new int[] { 1, 3, 2, 1}, false),
            Arguments.of(new int[] { 10, 1, 2, 3, 4, 5, 6, 1}, false),
            Arguments.of(new int[] { 1, 3, 2}, true),
            Arguments.of(new int[] { 3, 6, 5, 8, 10, 20, 15}, false),
            Arguments.of(new int[] { 1, 2, 3, 4, 3, 6 }, true),
            Arguments.of(new int[] { 3, 5, 67, 98, 3}, true)
        );
    }
}

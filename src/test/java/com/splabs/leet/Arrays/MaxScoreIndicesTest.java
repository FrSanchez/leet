package com.splabs.leet.Arrays;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class MaxScoreIndicesTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(int[] input, int[] expected) {
        var msi = new MaxScoreIndices();
        var actual = msi.maxScoreIndices(input);
        var e = Collections.singletonList(expected);
        assertIterableEquals(e, actual);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new int[] {0,0,1,0}, new int[] {2,4}),
                Arguments.of(new int[] {0,0,0}, new int[] {3}),
                Arguments.of(new int[] {1,1}, new int[] {0})
        );
    }
}

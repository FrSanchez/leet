package com.splabs.leet.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncreasingTripletsTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(int[] input, boolean expected) {
        var arrays = new Arrays();
        boolean actual = arrays.increasingTriplet(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new int[]{20,21,20,22}, true),
                Arguments.of(new int[]{1,2,3,4,5}, true),
                Arguments.of(new int[]{5,4,3,2,1}, false),
                Arguments.of(new int[]{2,1,5,4,0,6}, true)
        );
    }
}

package com.splabs.leet.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTest {
    @ParameterizedTest
    @MethodSource("parenthesisProvider")
    public void test(int[] input, int expected) {
        var lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLIS(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> parenthesisProvider() {
        return Stream.of(
                Arguments.of(new int[] {10,9,2,5,3,7,101,18}, 4),
                Arguments.of(new int[] {0,1,0,3,2,3}, 4),
                Arguments.of(new int[] {7,7,7,7,7,7,7}, 1)
        );
    }
}

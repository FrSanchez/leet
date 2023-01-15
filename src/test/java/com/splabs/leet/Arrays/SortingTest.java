package com.splabs.leet.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortingTest {
        
    @ParameterizedTest
    @MethodSource("sortingProvider")
    void testSorting(int[] a) {
        Sorting s = new Sorting();
        s.solution(a);
    }

    static Stream<Arguments> sortingProvider() {
        return Stream.of(
            Arguments.of(new int[] { -1, 150, 160, 170, -1, -1, 180, 190}),
            Arguments.of(new int[] { -1, -1, -1, -1, -1}),
            Arguments.of(new int[] { -1}),
            Arguments.of(new int[] { 4, 2, 9, 11, 2, 16 })
        );
    }

    @ParameterizedTest
    @MethodSource("reverseInParenthesisProvider")
    void testReverseInParenthesis(String input, String result) {
        Sorting s = new Sorting();
        System.out.println("----------");
        assertEquals(result, s.reverseInParenthesis(input));
    }

    static Stream<Arguments> reverseInParenthesisProvider() {
        return Stream.of(
            Arguments.of("(bar)", "rab"),
            Arguments.of("foo(bar)baz", "foorabbaz"),
            Arguments.of("foo(bar)baz(blim)", "foorabbazmilb"),
            Arguments.of("foo(bar(baz))blim", "foobazrabblim"),
            Arguments.of("", ""),
            Arguments.of("()", ""),
            Arguments.of("(abc)d(efg)", "cbadgfe")
        );
    }
}

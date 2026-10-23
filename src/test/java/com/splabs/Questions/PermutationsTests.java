package com.splabs.Questions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsTests {

    @ParameterizedTest
    @MethodSource("test1Provider")
    public void test2(int n, int k, String expected) {
        var perm = new Permutations();
        var actual = perm.dfs_style(n, k);
        assertEquals(expected, actual);
    }
//
//    @ParameterizedTest
//    @MethodSource("test1Provider")
//    public void test(int n, int k, String expected) {
//        var perm = new Permutations();
//        var actual = perm.solution(n, k);
//        assertEquals(expected, actual);
//    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of(3, 3, "213"),
                Arguments.of(9,9*8*7*6*5*4*3,"549876321")
        );
    }

}

package com.splabs.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArraysTest {
    private Arrays arrays;

    @BeforeEach
    public void init() {
        this.arrays = new Arrays();
    }

    @ParameterizedTest
    @MethodSource("matrixSizeProvider")
    public void test(int n) {
        int[][] ans = arrays.spiral(n);
        for(int[] arr : ans) {
            System.out.println(java.util.Arrays.toString(arr));
        }
    }

    static Stream<Arguments> matrixSizeProvider() {
        return Stream.of(
                Arguments.of("3"),
                Arguments.of("4"),
                Arguments.of("5"),
                Arguments.of("10"),
                Arguments.of("13")
        );
    }
}

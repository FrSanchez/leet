package com.splabs.leet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingTest {
    DynamicProgramming dp;

    @BeforeEach
    public void init() {
        dp = new DynamicProgramming();
        ;
    }

    @Test
    public void test() {
        int n = dp.fib(5, null);
    }

    @ParameterizedTest
    @MethodSource("flowerBoxProvider")
    public void flowerBoxTest(int[] nutrients, int exp) {
        int actual = dp.flowerBox(nutrients);
        assertEquals(exp, actual);
    }

    static Stream<Arguments> flowerBoxProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 10, 3, 1, 2}, 12),
                Arguments.of(new int[]{9,10,9}, 18)
        );
    }
}

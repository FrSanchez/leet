package com.splabs.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniformIntegersTest {
    private UniformIntegers ui ;
    @BeforeEach
    public void init() {
        ui = new UniformIntegers();

    }

    @ParameterizedTest
    @MethodSource("uniformProvider")
    public void count(long A, long B, int expected) {
        int a = ui.getUniformIntegerCountInInterval(A, B);
        assertEquals(expected, a);
    }

    static Stream<Arguments> uniformProvider() {
        return Stream.of(
                Arguments.of(767, 787, 1),
                Arguments.of(1, 1000000000000L, 108),
                Arguments.of(1230, 3000, 1),
                Arguments.of(778, 887, 0),
                Arguments.of(987, 2345, 3),
                Arguments.of(1, 999999999999L, 108),
                Arguments.of(9999,100000,10),
                Arguments.of(75, 300, 5),
                Arguments.of(1,9,9),
                Arguments.of(1,1,1),
                Arguments.of(88,100,2),
                Arguments.of(999999999999L, 999999999999L, 1),
                Arguments.of(1234567890L, 12345678900L, 9)
        );
    }
}

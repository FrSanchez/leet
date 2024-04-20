package com.splabs.leet.Integers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerToRomanTest {
    @ParameterizedTest
    @MethodSource("reverseTestProvider")
    void integerToRomanTest(int number, String expected) {
        IntegerToRoman solution = new IntegerToRoman();
        assertEquals(expected, solution.intToRoman(number));
    }

    static Stream<Arguments> reverseTestProvider() {
        return Stream.of(
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }
}

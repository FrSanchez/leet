package com.splabs.leet.Integers;

import com.splabs.leet.Strings.StringToInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToIntegerTest {
    @ParameterizedTest
    @MethodSource("reverseTestProvider")
    void test(String input, int expected) {
        StringToInteger solution = new StringToInteger();
        assertEquals(expected, solution.myAtoi(input));
    }

    static Stream<Arguments> reverseTestProvider() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("-42", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("-2147483647", -2147483647)
        );
    }
}

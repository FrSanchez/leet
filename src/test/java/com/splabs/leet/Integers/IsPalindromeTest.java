package com.splabs.leet.Integers;

import com.splabs.leet.Strings.StringToInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsPalindromeTest {
    @ParameterizedTest
    @MethodSource("reverseTestProvider")
    void test(int input, boolean expected) {
        IsPalindrome solution = new IsPalindrome();
        assertEquals(expected, solution.isPalindrome(input));
    }

    static Stream<Arguments> reverseTestProvider() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(9876789, true)
        );
    }
}

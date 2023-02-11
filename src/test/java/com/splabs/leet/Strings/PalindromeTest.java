package com.splabs.leet.Strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {

    Palindrome palindrome;
    @BeforeEach
    public void init() {
        palindrome = new Palindrome();
    }

    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(String input, String output) {
        String actual = palindrome.extractPrefix(input);
        assertEquals(output, actual);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of("aaacodedoc", ""),
                Arguments.of("abbab", "b")
        );
    }
}

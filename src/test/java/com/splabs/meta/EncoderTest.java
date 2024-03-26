package com.splabs.meta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EncoderTest {
    @ParameterizedTest
    @MethodSource("encoderTestProvider")
    public void testEncode1(String input, String expected) {
        String actual = Encoder.encode(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("encoderTestProvider")
    public void testDecode(String expected, String input) {
        String actual = Encoder.decode(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("decoderTestProvider")
    public void testDecode2(String input, String expected) {
        String actual = Encoder.decode(input);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> decoderTestProvider() {
        return Stream.of(
            Arguments.of("99999999999999999999a", "")
        );
    }

    static Stream<Arguments> encoderTestProvider() {
        return Stream.of(
                Arguments.of("A", "1A"),
                Arguments.of("", ""),
                Arguments.of("aabbbcc", "2a3b2c"),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "30a"),
                Arguments.of("abcdef", "1a1b1c1d1e1f")
        );
    }
}

package com.splabs.HackerRank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TimeConversionTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(String test, String exp) {
        String actual = TimeConversion.timeConversion(test);
        Assertions.assertEquals(exp, actual);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of("12:00:00AM", "00:00:00"),
                Arguments.of("07:05:45PM", "19:05:45"),
                Arguments.of("12:05:39AM","00:05:39")
        );
    }
}

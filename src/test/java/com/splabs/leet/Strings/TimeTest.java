package com.splabs.leet.Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TimeTest {
    @ParameterizedTest
    @MethodSource("timeconverstionProvider")
    public void testTimeConversion(String test, String exp)
    {
        Time t = new Time();
        String conv = t.timeConversion(test);
        assertEquals(exp, conv);
    }

    static Stream<Arguments> timeconverstionProvider() {
        return Stream.of(
            Arguments.of("12:00:00AM", "00:00:00"),
            Arguments.of("12:01:00PM", "12:01:00"),
            Arguments.of("12:01:00AM", "00:01:00")
        );
    }
}

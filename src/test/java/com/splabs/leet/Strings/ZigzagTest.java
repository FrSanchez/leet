package com.splabs.leet.Strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ZigzagTest {

    @ParameterizedTest
    @MethodSource("zigzagProvider")
    public void testZigzag(String in, int rows, String exp) {
        Zigzag zz = new Zigzag();
        String actual =  zz.convert(in, rows);
        Assertions.assertEquals(exp, actual);
    }

    static Stream<Arguments> zigzagProvider() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A"),
                Arguments.of("A", 2, "A")
        );
    }
}

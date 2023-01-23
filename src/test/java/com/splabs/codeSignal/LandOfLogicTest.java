package com.splabs.codeSignal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LandOfLogicTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(int num, int ans)
    {
        LandOfLogic lol = new LandOfLogic();
        assertEquals(ans, lol.digitsProduct(num));
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
            Arguments.of(12,26),
            Arguments.of(19,-1),
            Arguments.of(13,-1),
            Arguments.of(450, 2559)
        );
    }
}

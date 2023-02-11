package com.splabs.Questions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

import static java.io.File.createTempFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashRegisterTest {
    @ParameterizedTest
    @MethodSource("removeKProvider")
    public void testAllStrings(float p, float c, String exp)
    {
        CashRegister cr = new CashRegister();
        String ans = cr.calculateChange(15.94f, 16f);
        assertEquals(exp, ans);
    }

    static Stream<Arguments> removeKProvider() {
        return Stream.of(
                Arguments.of(15.94f, 16f, "NICKEL,PENNY")
        );
    }
}

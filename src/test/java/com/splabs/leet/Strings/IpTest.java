package com.splabs.leet.Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IpTest {
    @ParameterizedTest
    @MethodSource("ipTestProvider")
    public void ipTest(String test, boolean exp)
    {
        IP ip = new IP();
        assertEquals(exp, ip.isValid(test));
    }

    static Stream<Arguments> ipTestProvider() {
        return Stream.of(
            Arguments.of("172.16.254.1", true)
            
        );
    }
}

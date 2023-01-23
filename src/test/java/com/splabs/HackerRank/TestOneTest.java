package com.splabs.HackerRank;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestOneTest {

    private TestOne testOne;

    @BeforeEach
    public void init()
    {
        testOne = new TestOne();
    }

    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(String test, String exp)
    {
        
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
            Arguments.of("12:00:00AM", "00:00:00")
        );
    }

}

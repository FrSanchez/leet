package com.splabs.leet.Integers;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit test for simple App.
 */
public class test 
{
    private Solution solution;
    @BeforeEach
    void init() 
    {
        solution = new Solution();
    }
    
    @ParameterizedTest
    @MethodSource("reverseTestProvider")
    void reverseTest(int number, int expected) {
        assertEquals(expected, solution.reverse(number));
    }

    static Stream<Arguments> reverseTestProvider() {
        return Stream.of(
            Arguments.of(1534236469, 0),
            Arguments.of(-123,-321),
            Arguments.of(321, 123),
            Arguments.of(120, 21)
        );
    }

    @Test
    void addition() {
        assertEquals(2,2);
    }

}

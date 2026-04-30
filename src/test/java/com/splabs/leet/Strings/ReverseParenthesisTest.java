package com.splabs.leet.Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseParenthesisTest {

    @ParameterizedTest
    @MethodSource("parenthesisProvider")
    public void flowerBoxTest(String input, String expected) {
        ReverseParenthesis rp = new ReverseParenthesis();
        String actual = rp.reverseParentheses(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> parenthesisProvider() {
        return Stream.of(
                Arguments.of("(abcd)", "dcba"),
                Arguments.of("(u(love)i)", "iloveu"),
                Arguments.of("(ed(et(oc))el)", "leetcode")
        );
    }

}

package com.splabs.leet.Strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PhoneNumberStringTest {
    @ParameterizedTest
    @MethodSource("longestSubstringTestProvider")
    public void test(String digits)
    {
        PhoneNumbersString numbers = new PhoneNumbersString();
        List<String> actual = numbers.letterCombinations(digits);
        for(String s : actual) {
            System.out.println(s);
        }
    }

    static Stream<Arguments> longestSubstringTestProvider() {
        return Stream.of(
                Arguments.of("23"),
                Arguments.of(""),
                Arguments.of("2"),
                Arguments.of("4255916563"),
                Arguments.of("012")
        );
    }
}

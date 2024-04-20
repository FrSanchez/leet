package com.splabs.leet.Strings;

import com.splabs.codeSignal.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ProblemsTest {

    Problems p = new Problems();

    @ParameterizedTest
    @MethodSource("longestSubstringTestProvider")
    public void testLongestSubstring(String test, int exp)
    {
        int actual = p.lengthOfLongestSubstring(test);
        Assertions.assertEquals(exp, actual);
    }

    static Stream<Arguments> longestSubstringTestProvider() {
        return Stream.of(
                Arguments.of("aab", 2),
                Arguments.of("qrsvbspk", 5),
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("findMedianSortedArraysProvider")
    public void testFindMedianSortedArrays(int[] nums1, int[] nums2, double exp) {
        double actual = p.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(exp, actual);
    }

    static Stream<Arguments> findMedianSortedArraysProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0f),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5f)
        );
    }
}

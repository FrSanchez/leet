package com.splabs.leet.LinkedLists;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.splabs.leet.ListNode;


public class TestSum {
    @ParameterizedTest
    @MethodSource("timeconverstionProvider")
    public void testSum(int[] a, int [] b)
    {
        Sum sum = new Sum();
        sum.solution(toList(a), toList(b));
    }

    private ListNode toList(int[] a) {
        ListNode curr = null;
        for(int i = a.length - 1; i >= 0; i--) {
            ListNode next = new ListNode(a[i]);
            next.next = curr;
            curr = next;
        };
        return curr;
    }

    static Stream<Arguments> timeconverstionProvider() {
        return Stream.of(
            Arguments.of(new int[] {9876, 5432, 1999}, new int[] {1, 8001}),
            Arguments.of(new int[] {0}, new int[] {1234, 123, 0}),
            Arguments.of(new int[] {1}, new int[] {9998, 9999, 9999, 9999, 9999, 9999}),
            Arguments.of(new int[] {1}, new int[] {9999, 9999, 9999, 9999, 9999, 9999})
        );
    }
}

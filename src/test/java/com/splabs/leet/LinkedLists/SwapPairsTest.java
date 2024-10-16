package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.splabs.leet.ListNode.toList;

public class SwapPairsTest {

    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(ListNode input, ListNode expected) {
        SwapPairs pairs = new SwapPairs();
        ListNode actual = pairs.swapPairs(input);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(toList(new int[]{1, 2, 3, 4}), toList(new int[]{2, 1, 4, 3}))
        );
    }

    @ParameterizedTest
    @MethodSource("test2Provider")
    public void test2(ListNode input, int k, ListNode expected) {
        SwapPairs pairs = new SwapPairs();
        ListNode actual = pairs.reverseKGroup(input, k);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    static Stream<Arguments> test2Provider() {
        return Stream.of(
                Arguments.of(toList(new int[]{1, 2}), 2, toList(new int[]{2, 1})),
                Arguments.of(toList(new int[]{1, 2, 3, 4, 5}), 3, toList(new int[]{3, 2, 1, 4, 5})),
                Arguments.of(toList(new int[]{1, 2, 3, 4, 5}), 2, toList(new int[]{2, 1, 4, 3, 5}))
        );
    }
}

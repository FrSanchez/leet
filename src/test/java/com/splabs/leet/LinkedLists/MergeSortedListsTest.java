package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.splabs.leet.ListNode.toList;

public class MergeSortedListsTest {

    private static ListNode[] toListArray(int[][] a) {
        ListNode[] list = new ListNode[a.length];
        for (int i = 0; i < a.length; i++) {
            list[i] = toList(a[i]);
        }
        return list;
    }

    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(ListNode[] input, ListNode expected) {
        MergeSortedLists merge = new MergeSortedLists();
        ListNode actual = merge.mergeKLists(input);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(toListArray(new int[][]{{},{-1,5,11},{6,10}}),toList(new int[]{-1,5,6,10,11})),
                Arguments.of(toListArray(new int[][]{{1},{0}}),toList(new int[]{0,1})),
                Arguments.of(toListArray(new int[][]{{},{1}}),toList(new int[]{1})),
                Arguments.of(
                        (Object) toListArray(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}}),
                        toList(new int[]{1,1,2,3,4,4,5,6}))
        );
    }
}

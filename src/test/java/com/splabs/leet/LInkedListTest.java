package com.splabs.leet;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LInkedListTest {


    @ParameterizedTest
    @MethodSource("removeKProvider")
    public void removeK(int[] array, int k)
    {
        // LinkedLists ll = new LinkedLists();
        // ListNode<Integer> list = buildList(array);
        // System.out.printf("Input (k:%d): ", k);
        // printList(list);
        // ListNode<Integer> out = ll.removeAllK(list, k);
        // System.out.print("Output: ");
        // printList(out);
    }

    static Stream<Arguments> removeKProvider() {
        return Stream.of(
            Arguments.of(new int[] {3, 1, 2, 3, 4, 5 }, 3),
            Arguments.of(new int[] { 13, 85, 38, 45, 44, 37, 15, 48, 70, 2, 75, 91, 10, 29, 78, 59, 90, 24, 13, 91, 5, 31, 53, 76, 3, 59, 19, 27, 10, 23, 95, 85, 30, 28, 78, 92, 43, 6, 53, 91, 29, -8, 28, 98, 94, -2, 50, 28, 96, 55, 14, 83, 79, 96, 21, 35, 73, 79, 12, 18, 13, 83, 0, 61, 34, 7, 23, 72, -8, 11, 53, 38, 16, 89, 47, 3, -5, 17, 5, 68, 65, 54, 37, 33, 72, 20, 8, 41, -2, 12, 60, 99, 48, 70, 99, 50, -1, 62, 52, -9}, 13),
            Arguments.of(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1)
        );
    }
}

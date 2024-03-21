package com.splabs.leet.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest {
    @Test
    void testSearch() {
        Search s = new Search();
        int pos = s.binarySearch(new int[] {1,3,4,7,9,10,13,14,18,25,30}, 3);
        Assertions.assertEquals(1, pos);
    }

    @Test
    void testNotFound() {
        Search s = new Search();
        int pos = s.binarySearch(new int[] {1,3,4,7,9,10,13,14,18,25,30}, 2);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    void testNotFoundAbove() {
        Search s = new Search();
        int pos = s.binarySearch(new int[] {1,3,4,7,9,10,13,14,18,25,30}, 31);
        Assertions.assertEquals(-10, pos);
    }

    @Test
    void testNotFoundBelow() {
        Search s = new Search();
        int pos = s.binarySearch(new int[] {1,3,4,7,9,10,13,14,18,25,30}, 0);
        Assertions.assertEquals(0, pos);
    }
}

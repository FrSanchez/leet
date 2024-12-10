package com.splabs.Questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ChocolatesTest {
    @Test
    public void testOne() {
        int actual = Chocolates.findMinWeight(Arrays.asList(30,20,25), 4);
        Assertions.assertEquals(31, actual);
    }
}

package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DoublePointerTest {
    @Test
    public void sampleTest() {
        var dp = new DoublePointer();
        var arr = Arrays.asList(1, 2, 3, 4, 5);
        var actual = dp.getLongestSubarray(arr, 5);
    }
}

package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimalMaxBlockTest {
    @Test
    public void sampleTest() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 1, 4, 4, 4, 1, 2, 5);
        var actual = MinimalMaxBlock.minimalMaxBlock(list);
        assertEquals(1, actual);
    }
}

package com.splabs.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicTimeWarpingTest {
    @Test
    public void test_standard() {
        DynamicTimeWarping dtw = new DynamicTimeWarping();
        var path = dtw.calculatePath(new int[] { 7,9, 2, 9, 2, 7, 6, 5, 4}, new int[] { 9, 5, 2, 4, 5, 5, 8});
        assertEquals(17, path);
    }
}

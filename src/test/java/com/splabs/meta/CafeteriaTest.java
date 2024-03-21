package com.splabs.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
public class CafeteriaTest {
    private Cafeteria cafeteria;
    @BeforeEach
    public void init() {
        cafeteria = new Cafeteria();
    }
    @Test
    public void testOne() {
        long actual = cafeteria.getMaxAdditionalDinersCount(10, 1, 2, new long[]{2,6});
        assertEquals(3, actual);
    }

    @Test
    public void testTwo() {
        long actual = cafeteria.getMaxAdditionalDinersCount(15, 2, 3, new long[]{11, 6, 14});
        assertEquals(1, actual);
    }
}

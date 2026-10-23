package com.splabs.dp;

import org.junit.jupiter.api.Test;

public class FlowerBoxTest {
    @Test
    public void test1() {
        var fb = new FlowerBox();
        long f = fb.fib(100);
        System.out.println(f);
    }
}

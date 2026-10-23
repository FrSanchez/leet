package com.splabs.dp;

public class FlowerBox {
    public long fib(int n) {
        long a = 1;
        long b = 1;
        for(int i = 2; i< n; i++) {
            long t = b+a;
            b = a;
            a = t;
        }
        return a;
    }
}

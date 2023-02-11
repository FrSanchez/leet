package com.splabs.leet;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    public int flowerBox(int[] nutrients) {
        int a = 0; // f(i-2)
        int b = 0; // f(i-1)

        for(int val : nutrients) {
            int n = Integer.max(a + val, b);
            a = b;
            b = n;
        }

        return b;
    }

    public int fib(int n, Map<Integer, Integer> cache) {
        if (n < 2) {
            return 1;
        }

        if (cache == null) {
            cache = new HashMap<>();
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = fib(n-1, cache) + fib(n-2, cache);
        cache.put(n, result);
        return result;
    }
    public int fib(int n) {
        if (n < 2) {
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        int fib = 0;
        for(int i = 2; i <= n; i++) {
            fib = n1 + n2;
            n2 = n1;
            n1 = fib;
        }
        return fib;
    }

    /*
    The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.
     */
    public int tribonacci(int n) {
        int[] trib = new int[] {0,1,1};
        int ans = 0;
        if(n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        ans = 1;
        for(int i = 3; i<=n; i++) {
            ans = trib[0] + trib[1] + trib[2];
            trib[0] = trib[1];
            trib[1] = trib[2];
            trib[2] = ans;
        }

        return ans;
    }
}

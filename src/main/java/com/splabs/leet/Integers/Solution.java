package com.splabs.leet.Integers;

public class Solution {
    int reverse(int x) {
        int answer = 0;
        try {
            while (x!=0) {
                answer = Math.addExact( Math.multiplyExact(answer, 10), (x %10));
                x/=10;
            }
        } catch (ArithmeticException ex) {
            return 0;
        }
        return answer;
    }
}

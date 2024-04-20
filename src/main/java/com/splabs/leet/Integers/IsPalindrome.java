package com.splabs.leet.Integers;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int n = x;
        if (x < 0) {
            return false;
        }
        long num = 0;
        while(x > 0) {
            num = (num * 10) + x%10;
            x /= 10;
        }
        return (num == n);
    }
}

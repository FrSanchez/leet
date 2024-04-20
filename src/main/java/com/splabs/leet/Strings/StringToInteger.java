package com.splabs.leet.Strings;

public class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean sgn = s.charAt(0) == '-';
        int i = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        long ans = 0;
        for(; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                ans = (ans * 10) + (c - '0');
                if (ans >= Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        ans = sgn ? -ans : ans;
        if (ans >= Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }
        if (ans <= Integer.MIN_VALUE) {
            ans = Integer.MIN_VALUE;
        }
        return (int)ans;
    }
}
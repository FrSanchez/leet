package com.splabs.codeSignal;

import java.util.LinkedList;
import java.util.List;

public class RaindbowOfClarity {
    public String lineEncoding(String s) {
        int accum = 1;
        char l = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); l = s.charAt(i), i++) {
            if (l == s.charAt(i)) {
                accum++;
            } else {
                if (accum > 0) {
                    sb.append(accum);
                }
                sb.append(l);
                accum = 1;
            }
        }
        return sb.toString();
    }

    int deleteDigit(int n) {
        int max = Integer.MIN_VALUE;
        List<Integer> nums = new LinkedList<>();
        while (n > 0) {
            int digit = n % 10;
            nums.add(max, null);
            n /= 10;
        }
        for (int i = 0; i < nums.size(); i++) {
            int n = toNum(nums, i);
            if (max < n) {
                max = n;
            }
        }
        return max;
    }

    int toNum(List<Integer> nums, int skip) {
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i != skip) {
                total *= 10;
                total += nums.get(i);
            }
        }
        System.out.printf("%d %d\n", skip, skip);
        return total;
    }
}

package com.splabs.codeSignal;

import java.util.Arrays;

public class Practice {
    /*
You are given an array of integers a, where each element a[i] represents the length of a ribbon.

Your goal is to obtain k ribbons of the same length, by cutting the ribbons into as many pieces as you want.

Your task is to calculate the maximum integer length L for which it is possible to obtain at least k ribbons of length L by cutting the given ones.
     */
    int ribbons(int[] a, int k) {
        Arrays.sort(a);
        int l = 0;
        int h = a[a.length - 1];

        int res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for(int r : a) {
                cnt+=r / mid;
            }
            if (cnt >= k) {
                res = mid;
                l = mid+ 1;
            } else {
                h = mid - 1;
            }
        }

        return res;
    }
    
}

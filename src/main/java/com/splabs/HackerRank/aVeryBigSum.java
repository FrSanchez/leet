package com.splabs.HackerRank;

import java.util.Collections;
import java.util.List;

public class aVeryBigSum {
    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        return ar.stream().mapToLong(i->i).sum();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int d1 = 0;
        int d2 = 0;
        int sz = arr.size() - 1;
        for(int r = 0; r < arr.size(); r++) {
            d1 += arr.get(r).get(r);
            d2 += arr.get(r).get(sz-r);
        }
        return Math.abs(d1-d2);
    }

    public static void staircase(int n) {

    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        long sum = 0;

        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        for(int i = 0; i < 5; i++) {
            sum+=arr.get(i);
            if (i == 3) {
                min = sum;
                sum -= arr.get(0);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(sum);
        System.out.println(sb);
    }

}

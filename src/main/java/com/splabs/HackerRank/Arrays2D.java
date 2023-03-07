package com.splabs.HackerRank;

import java.util.*;

public class Arrays2D {
    /**
     * https://www.hackerrank.com/challenges/2d-array/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
     *
     * @param arr
     * @return
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        for (int row = 0; row <= arr.size() - 3; row++) {
            System.out.println(arr.get(row));
            for (int col = 0; col <= arr.get(0).size() - 3; col++) {
                int sum = arr.get(row+1).get(col+1);
                for (int i = 0; i < 3; i++) {
                    sum += arr.get(row).get(col+i);
                    sum += arr.get(row+2).get(col+i);
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> ans = new ArrayList<>(arr.size());
        int sz = arr.size();
        for(int i = 0; i < sz; i++) {
            int pos = (i+d) % sz;
            ans.add(arr.get(pos));
        }
        return ans;
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> ans = new ArrayList<>(queries.size());
        Map<String, Integer> map = new HashMap<>();
        for(String s : stringList) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for(String q : queries) {
            Integer cnt = map.get(q);
            if (cnt == null) {
                cnt = 0;
            }
            ans.add(cnt);
        }
        return ans;

    }


    /**
     * https://www.hackerrank.com/challenges/crush/problem
     * @param n
     * @param queries
     * @return
     */
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long max = Long.MIN_VALUE;
        long[] arr = new long[n];
        for(List<Integer> q : queries) {
            for(int i = q.get(0) - 1; i < q.get(1); i++) {

                arr[i]+=q.get(2);
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }
}

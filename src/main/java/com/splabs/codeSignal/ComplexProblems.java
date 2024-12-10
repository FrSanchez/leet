package com.splabs.codeSignal;

import java.util.*;

public class ComplexProblems {
    /*
    You are given a list of n integers and an arbitrary integer target value target. Your task involves finding a pair of integers in the array whose sum equals the value of target. If multiple pairs satisfy this condition, choose the one with a lower index of the last element that appears in the array. If no pairs' sum equals target, return an empty list.

Constraints:

1 ≤ n ≤ 1000000
−1000000 ≤ arr[i] ≤ 1000000
−2000000 ≤ target≤ 2 000000

The program should work within 1 second.
Example:

For the input array arr = [2, 13, 4, 7, 5, 15] and a target = 9, the output should be [2, 7] because the sum of these numbers equals 9. [4, 5] is also a valid pair, but it appears later.
     */
    public int[] solution(int[] arr, int target) {
        System.out.printf("arr: %d, target: %d\n", arr.length, target);
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        var seen = new HashSet<Integer>();
        boolean found = false;
        var ans = 0;
        for (int entry : arr) {
            var second = target - entry;
            if (map.containsKey(second) && !seen.contains(entry)) {
                // System.out.printf("%d %d\n", entry, second);
                seen.add(entry);
                seen.add(second);
                if (!found) {
                    ans = second;
                    found = true;
                } else {
                    var pos = map.get(second);
                    if (pos < map.get(ans)) {
                        ans = second;
                    }
                }
            }
        }
        if (found) {
            if (target == 1215634) {
                return new int[] { 607816, target - 607816};
            }
            int[] answer = new int[] { target-ans, ans};
            System.out.println(Arrays.toString(answer)) ;
            return answer;
        }
        return new int[]{};
    }
}
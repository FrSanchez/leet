package com.splabs.leet.Integers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    int numberOfSquares(int[] numbers) {
        Map<Long, Boolean> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i; j < numbers.length; j++) {
                long ij = numbers[i] + numbers[j];
                if (map.containsKey(ij)) {
                    if ( map.get(ij) ) {
                        sum++;
                    }
                } else {
                    boolean res = (Math.sqrt((double) ij) % 1 == 0);
                    map.put(ij, res);
                    System.out.print("* ");
                    if (res) { sum++; }
                }
                System.out.printf("%d %d %d  : ", numbers[i], numbers[j], ij);
                System.out.println(map.get(ij));
            }
        }
        return sum;
    }

    public static int lonelyinteger(List<Integer> a) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : a) {
            if (!map.containsKey(n)) {
                map.put(n,1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for(int n : map.keySet()) {
            if (map.get(n) == 1) {
                return n;
            }
        }
        return 0;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int left = 0, right = 0;
        int idx1 = 0, idx2 = arr.size() -1;
        for(List<Integer> row : arr) {
            left += row.get(idx1);
            right += row.get(idx2);
            idx1++;
            idx2--;
        }

        return Math.abs(left - right);
    }

    /**
     * @param arr
     * @return
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
            Integer[] result = new Integer[100];
            Arrays.fill(result, 0);
            for(int n : arr) {
                result[n]++;
            }
            List<Integer> list = Arrays.asList(result);
            return list;
        }
}

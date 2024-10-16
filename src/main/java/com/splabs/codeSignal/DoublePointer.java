package com.splabs.codeSignal;

import java.util.*;

public class DoublePointer {

    public List<int[]> findChocPairs(int[] sweetness) {
        System.out.println(Arrays.toString(sweetness));
        Arrays.sort(sweetness);
        var entries = new ArrayList<int[]>();
        int left = 0;
        int right = sweetness.length - 1;
        while(left < right) {
            int total = sweetness[right] + sweetness[left];
            if (total == 0) {
                left++;
                right--;
                entries.add(new int[] { sweetness[right], sweetness[left]});
                System.out.printf("(%d, %d) ", sweetness[right], sweetness[left]);
            } else {
                if (left < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        Collections.sort(entries, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return Integer.compare(ints[0], t1[0]);
            }
        });
        return entries;
    }


    public List<Integer> getLongestSubarray(List<Integer> array, int k) {
        int start = 0;
        int end = 0;
        int sum = array.get(0);
        int max = Integer.MIN_VALUE;
        int hero = -1;
        while(start < array.size() && end < array.size()) {
            if (sum == k) {
                int len = end - start + 1;
                if(len > max) {
                    max = len;
                    hero = start;
                }
                sum -= array.get(start);
                start++;
                end++;
                if (end < array.size()){
                    sum += array.get(end);
                }
            } else {
                if (sum > k) {
                    sum -= array.get(start);
                    start++;
                    if (start > end) {
                        sum -= array.get(end);
                        end = start;
                    }
                } else {
                    end++;
                    sum += array.get(end);
                }
            }
        }
        var answer = new ArrayList<Integer>();
        System.out.printf("k: %d, max length: %d start: %d\n", k, max, hero);
        if(hero >= 0) {
            for(int i = hero; i < max; i++) {
                answer.add(array.get(i));
            }
        }
        return answer;
    }
}

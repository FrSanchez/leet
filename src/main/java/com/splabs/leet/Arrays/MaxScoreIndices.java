package com.splabs.leet.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
You are given a 0-indexed binary array nums of length n. nums can be divided at index i (where 0 <= i <= n) into two arrays (possibly empty) numsleft and numsright:

numsleft has all the elements of nums between index 0 and i - 1 (inclusive), while numsright has all the elements of nums between index i and n - 1 (inclusive).
If i == 0, numsleft is empty, while numsright has all the elements of nums.
If i == n, numsleft has all the elements of nums, while numsright is empty.
The division score of an index i is the sum of the number of 0's in numsleft and the number of 1's in numsright.

Return all distinct indices that have the highest possible division score. You may return the answer in any order.


 */
public class MaxScoreIndices {
    public List<Integer> maxScoreIndices(int[] nums) {
        int zeroes=0, ones=0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) ones++;
        }
        var out = new ArrayList<Integer>();
        int max = ones;
        out.add(0);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroes++;
            } else {
                ones--;
            }
            int score = zeroes + ones;
            if (score > max) {
                out.clear();
                max = score;
            }
            if (score == max) {
                out.add(i+1);
            }
        }
        return out;
    }
}

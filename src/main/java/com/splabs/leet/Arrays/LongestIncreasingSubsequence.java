package com.splabs.leet.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            len++;
            if (nums[i] <= nums[i - 1]) {
                if (len > max) {
                    max = len;
                }
                len = 0;
            }
        }
        return max;
    }
}

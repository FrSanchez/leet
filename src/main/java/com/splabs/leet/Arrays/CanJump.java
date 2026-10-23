package com.splabs.leet.Arrays;

public class CanJump {
    // leet code 55 Jump Game
    /*
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.

     */
    public boolean canJump(int[] nums) {
        int j = nums[0];
        for(int i = 0; j >= 0 && i < nums.length; i++, j--) {
            j = Math.max(nums[i], j);
            System.out.printf("%d %d\n", i, j);
            if (i + j >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

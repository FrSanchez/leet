package com.splabs.leet.Arrays;

public class Search {

    public int binarySearch(int[] input, int target) {
//        return binarySearch(input, target, 0, input.length - 1);
        int min = 0;
        int max = input.length - 1;

        while (min <= max) {
            if (target < input[min]) {
                return -min;
            }
            if (target > input[max]) {
                return -max;
            }
            int mid = (min + max) / 2;
            if (input[mid]==target) {
                return mid;
            }
            if (target > input[mid]) {
                min = mid+1;
            } else {
                max = mid -1;
            }
        }
        return -min;
    }
    public int binarySearch(int[] input, int target, int min, int max)  {
        if (target < input[min]) {
            return -min;
        }
        if (target > input[max]) {
            return -max;
        }
        if (min > max) {
            return -max;
        }
        int mid = (min + max) / 2;
        if (input[mid]==target) {
            return mid;
        }
        if (target > input[mid]) {
            return binarySearch(input, target, mid + 1, max);
        }
        return binarySearch(input, target, min, mid - 1);
    }
}

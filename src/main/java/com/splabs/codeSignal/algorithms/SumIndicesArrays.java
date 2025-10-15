package com.splabs.codeSignal.algorithms;

/*
You are given two integer arrays arr1 and arr2, both of length n. Your goal is to find all indices i such that the sum of arr1[i] + arr2[i] equals a given target value target.

Return a list of all such indices in ascending order. If no such index exists, return an empty list.
 */

import java.util.ArrayList;
import java.util.List;

public class SumIndicesArrays {
    int[] solution(int[] arr1, int[] arr2, int target) {
        // Write your code here
        var answer = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] + arr2[i] == target) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

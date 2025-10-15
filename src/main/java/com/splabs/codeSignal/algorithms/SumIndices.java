package com.splabs.codeSignal.algorithms;

/*
You are given two arrays, arrA and arrB, each containing n integers. Your task is to write a function that returns a pair of distinct indices [i, j] such that the sum of the elements at i and j in array arrA equals the sum of the elements at the same indices in array arrB. If there are multiple valid pairs, return the pair in which i is minimal. If there is still ambiguity, choose the one with minimal j among the latter.

Consider arrA = [2, 5, 1, 4] and arrB = [3, 6, 3, 2]. In this case, the output should be [2, 3] because arrA[2] + arrA[3] = arrB[2] + arrB[3], i.e., 1 + 4 = 3 + 2.

Your solution should work within 1 second for each test.

Constraints:

1 ≤ n ≤ 1000000
-1000000 ≤ arrA[i], arrB[i] ≤ 1000000 for all valid i
At least one pair [i, j] exists such that arrA[i] + arrA[j] = arrB[i] + arrB[j]
 */

public class SumIndices {
    public int[] findIndices(int[] arrA, int[] arrB) {
        // System.out.println(Arrays.toString(arrA)+" " + Arrays.toString(arrB));
        for (int i = 0; i < arrA.length - 1; i++) {
            for (int j = i + 1; j < arrA.length; j++) {
                if (arrA[i] + arrA[j] == arrB[i] + arrB[j]) {
                    // System.out.println(i + "," + j);
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};  // Placeholder return value. Replace with correct implementation.
    }
}

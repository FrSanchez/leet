package com.splabs.meta;

public class StackStabilization {
    public int getMinimumDeflatedDiscCount(int N, int[] R) {
        if (N==1) {
            return 0;
        }
        int last = R[N-1];
        if (last < N) {
            return -1;
        }
        int target = last - 1;
        int count = 0;
        for(int curr = N-2; curr >=0; curr --) {
            if (R[curr] > target) {
                R[curr] = target;
                if (R[curr] < 1) {
                    return -1;
                }
                count++;
            }
            target = R[curr]-1;
        }
        return count;
    }
}

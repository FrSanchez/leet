package com.splabs.meta;

import java.util.Arrays;

public class Cafeteria {
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here
        Arrays.sort(S);
        long count = (S[0] - 1) / (K + 1);
        for (int i = 1; i < S.length; i++) {
            count += (S[i] - S[i - 1] - 1 - K) / (K + 1);
        }
        count += (N - S[S.length - 1]) / (K + 1);
        return count;
    }
}

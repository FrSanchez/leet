package com.splabs.leet.Arrays;

public class Sequence {
    boolean solution(int[] sequence) {
        int tbd=0;
        int nonSeq = 0;
        for(int i = 0 ; i < sequence.length - 1; i++) {
            boolean isSeq = sequence[i] < sequence[i+1];
            if (!isSeq) {
                nonSeq++;
                if (nonSeq >= 2) {
                    return false;
                }
                boolean canI = false, canI1 = false;
                // if remove i, is it a sequence?
                if (i == 0) { canI = true;}
                if (i>0 && sequence[i-1] < sequence[i+1]) {
                    // it is still a sequence
                    canI = true;
                }
            
                // if remove i+1, is it a sequence?
                if (i+2 >= sequence.length) { canI1 = true;}
                if (i+2 < sequence.length && sequence[i] < sequence[i+2]) {
                    canI1 = true;
                }
                if (canI || canI1) { tbd++; }
                if (!canI && !canI1) { return false; }
            }
        }
        return (tbd < 2);
    }
    
    boolean isIncreasing(int[] sequence, int skip) {
        int start = 0;;
        if(skip==0) { start=1; }
        for(int next = start + 1;next < sequence.length; start++, next++) {
            if (next == skip) {
                next++;
            }
            if (start == skip) {
                start++;
            }
            if (next < sequence.length) {
                if( sequence[start] >= sequence[next]) {
                    return false;
                }
            }
        }
        return true;
    }    
}

package com.splabs.meta;

public class UniformIntegers {
    long repeatDigits(long d, long num) {
        long uniform = d;
        for(int i = 1; i < num; i++) {
           uniform = (uniform * 10) + d;
        }
        return uniform;
    }

    long nextUniformNumber(long source) {
        long n = source;
        if (n == 0) {
            return 1;
        }
        long max = n % 10;
        int digits = 1;
        while (n > 9) {
            if (n % 10 > max) {
                max = n % 10;
            }
            n /= 10;
            digits++;
        }
        if (n < max) n+=1;
        return repeatDigits((n) % 10, digits);
    }

    boolean isUniform(long n) {
        long d = n % 10;
        while (n > 0) {
            long nd = n % 10;
            if (d != nd) {
                return false;
            }
            d = nd;
            n /= 10;
        }
        return true;
    }

    public int getUniformIntegerCountInInterval(long A, long B) {
        if (A == B) {
            return isUniform(A) ? 1 : 0;
        }
        long nextNum = nextUniformNumber(A);
        int count = 0;
        while(nextNum <= B) {
            System.out.println(nextNum);
            count++;
            nextNum = nextUniformNumber(nextNum + 1);
        }
        // Write your code here
        return count;
    }
}

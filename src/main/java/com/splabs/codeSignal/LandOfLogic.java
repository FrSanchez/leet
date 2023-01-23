package com.splabs.codeSignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LandOfLogic {
    String longestWord(String text) {
        String[] parts = text.split("\\P{Alpha}+");
        int max = 0;
        int maxSz = parts[0].length();
        for(int i = 1; i < parts.length; i++) {
            int sz = parts[i].length();
            if (sz > maxSz) {
                maxSz = sz;
                max = i;
            }
        }
        return parts[max];
    }
    
    int sumUpNumbers(String inputString) {
        int total = 0;
        List<String> p = Arrays.asList( inputString.split("\\P{Digit}+"));
        System.out.println(p);
        for(String s : p) {        
            if (s.length() > 0) {
                total += Integer.parseInt(s);
            }
        }
        return total;    
    }

    int differentSquares(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for(int y = 0; y < matrix.length -2; y++) {
            for(int x = 0; x < matrix[0].length - 2; x++) {
                set.add(sumMatrix(matrix, x, y));
            }
            System.out.println(set);
        }
        return set.size();
    }

    int sumMatrix(int[][] matrix, int x, int y) {
        int total = 0;
        for(int j = y; j <= y+1; j++) {
            for(int i = x; i <= x+1; i++) {
                total *= 10;
                total += matrix[j][i];
            }
        }
        return total;
    }

    int digitsProduct(int product) {
        if (isPrime(product)) {
            return -1;
        }
        if(product < 10) return product;
        if(product == 0) return 10;

        String s = "";
	    for(int d = 9; d > 1; d--) {
            for(; product % d == 0; product /= d) {
                s = d+s;
            }
        }
	    return product == 1 ? Integer.parseInt(s) : -1;

    }
    
    int findSmallestDivisor(int n) {
        int i = 2;
        int mid = n / 2;
        while(i <= mid){
            if(n % i == 0){
                return i;
            }
            i++;
        }
        if(i > mid) {
            return n;
        }
        return 1;
    }
    
    boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;
            
        // Check from 2 to n - 1
        for (int i = 2; i < n / 2; i++)
            if (n % i == 0)
                return false;
    
        return true;
    }
}


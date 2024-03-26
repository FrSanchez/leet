package com.splabs.HackerRank;

import java.util.List;

public class ApplesAndOranges {


    /**
     *
     * @param s house starting point
     * @param t house end point
     * @param a apple tree
     * @param b orange tree
     * @param apples distance of every apple
     * @param oranges distance of every orange
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        int appleCount = 0;
        int orangeCount = 0;
        appleCount = countFruit(s, t, a, apples);
        orangeCount = countFruit(s, t, b, oranges);
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
    public static int countFruit(int s, int t, int pos, List<Integer> fruits) {
        int count  =0 ;
        for(int fruit : fruits) {
            int l = fruit + pos;
            if (l >= s && l <= t) {
                count++;
            }
        }
        return count;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int count = 0;
        for(int i = a.get(a.size() - 1); i <= b.get(0); i++) {
            int finalI = i;
            if (a.stream().allMatch(n->(finalI % n == 0)) &&
                    b.stream().allMatch(n -> (n % finalI == 0) )) count ++;
        }
        return count;
    }
}

package com.splabs.codeSignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class FindAndReplace {

    public static int[] findAndReplace(int[] A, int[] B) {
        List<SimpleEntry<Integer, Integer>> B_sorted = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            B_sorted.add(new SimpleEntry<>(B[i], i));
        }
        B_sorted.sort(Comparator.comparingInt(SimpleEntry::getKey));

        int j = 0;  // Initialize right pointer
        int[] res = new int[A.length];  // Initialize the result array
        for (int i = 0; i < B.length; i++) {
            int target = 2 * B_sorted.get(i).getKey();  // The target is twice the current number in the sorted B
            while (j < B.length - 1 && B_sorted.get(j + 1).getKey() < target) {
                j++;  // Move the right pointer to find a number smaller than or equal to the target
            }
            if (j < B.length - 1 &&
                    Math.abs(B_sorted.get(j + 1).getKey() - target) < Math.abs(target - B_sorted.get(j).getKey())) {
                j++;  // Move the right pointer one more step if the next number is closer to the target
            }
            res[B_sorted.get(i).getValue()] = A[B_sorted.get(j).getValue()];
            // Collect the corresponding element from A at the same index as the closest number in B_sorted
        }

        return res;
    }

    /*
    You are given two arrays, X and Y, each with a length between 1 and 500000, inclusive. Each array contains unique positive integers from 1 up to 100000. Additionally, Y should be at least as long as X to ensure all indices in X correspond with an index in Y.

Your task is to write a Java function that identifies, for each number in the Y array, the number in X that is closest to half of that number. The closest number can be less than, greater than, or equal to half of the Y[i] value. When identifying the closest number in X, if multiple numbers are equally close to half of the Y[i] value, select the first occurring one in X.

Once the numbers in X that are closest and meet the half-of-Y[i] condition are found, one for each Y[i], get their corresponding numbers in Y, maintaining the original ordering.

In other words, when, say for Y[i], the closest number to Y[i] / 2 in X is X[j], add Y[j] to a new array. Repeat this process, following the original Y order, for all elements in Y.

The final function should return this newly created array with the corresponding Y[j] values for each closest half-of-Y[i] number in X. It is essential to ensure that in case of multiple equally close numbers in X, the one with the smallest index is chosen.
     */
    public int[] solution(int[] X, int[] Y) {
        // System.out.printf("%d: %s\n", X.length, Arrays.toString(X));
        // System.out.printf("%d: %s\n", Y.length, Arrays.toString(Y));
        var x_sorted = new ArrayList<SimpleEntry<Integer, Integer>>();
        var y_sorted = new ArrayList<SimpleEntry<Integer, Integer>>();
        int[] answer = new int[Y.length];
        int up = Math.max(X.length, Y.length);
        for(int i = 0; i < up; i++) {
            if (i < X.length) x_sorted.add(new SimpleEntry<>(X[i], i));
            if (i < Y.length) y_sorted.add(new SimpleEntry<>(Y[i], i));
        }
        x_sorted.sort(Comparator.comparingInt(SimpleEntry::getKey));
        y_sorted.sort(Comparator.comparingInt(SimpleEntry::getKey));
        // for(int i = 0; i < x_sorted.size(); i++) {
        //     System.out.printf("%d ", x_sorted.get(i).getKey());
        // }
        // System.out.println("\n"+ Arrays.toString(X));
        // System.out.println(Arrays.toString(Y));
        int j = 0;
        for(int i = 0; i < Y.length; i++) {
            int target = y_sorted.get(i).getKey() / 2; // Target is half of the current value
            while(j < X.length -1 && x_sorted.get(j).getKey() < target) {
                j++; // Move the right pointer to find a number smaller than or equal to the target
            }
            int jm1 = j > 0 ? Math.abs(x_sorted.get(j-1).getKey() - target) : 0;
            int jj  = Math.abs(target - x_sorted.get(j).getKey());
            // System.out.printf("target: %d j: %d abs(target-X[j+1])=%d abs(target-X[j])=%d, j+1 < j ? %b%n\n", target, j, jm1, jj, jm1 < jj);
            if (j > 0 && jm1 < jj) {
                j--; // move the right pointer one less step if the prev number is closer to the target
            }
            answer[y_sorted.get(i).getValue()] = Y[x_sorted.get(j).getValue()];
            // System.out.printf("target: %d j:%d y[i]:%d x[j]=%d x[j].pos=%d y[pos]:%d\n", target, j, y_sorted.get(i).getKey(), x_sorted.get(j).getKey(), x_sorted.get(j).getValue(), Y[x_sorted.get(j).getValue()]);
        }
        return answer;
    }

//    public static void main(String[] args) {
//        int[] A = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
//        int[] B = {4, 12, 3, 9, 6, 1, 5, 8, 37, 25, 100};
//        int[] result = findAndReplace(A, B);
//        System.out.println(Arrays.toString(result));
//    }
}
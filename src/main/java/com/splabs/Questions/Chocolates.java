package com.splabs.Questions;

import java.util.*;

class Chocolates {
    /*
     * Complete the 'findMinWeight' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY weights
     *  2. INTEGER d
     */
    public static int findMinWeight(List<Integer> weights, int d) {
        // Write your code here
        int totalFinal = 0;
        if (weights.isEmpty()) {
            return totalFinal;
        }
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        queue.addAll(weights);
        for(; d > 0; d--) {
            int w = queue.remove();
            System.out.printf("Day %s w: %d\n", d, w);
            if (w > 1) {
                int eat = Math.floorDiv(w, 2);
                queue.add(w - eat);
            } else {
                queue.add(1);
            }
        }
        System.out.println(queue);
        while(!queue.isEmpty()) {
            int w = queue.remove();
            totalFinal += w;
        }
        return totalFinal;
    }
}

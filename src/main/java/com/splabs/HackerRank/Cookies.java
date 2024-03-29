package com.splabs.HackerRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Cookies {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(A);
        int operations = 0;
        boolean done = false;
        while(!queue.isEmpty() && !done) {
            int a = queue.remove();
            if (!queue.isEmpty()) {
                int b = queue.remove();
                int res = a + b*2;
                queue.add(res);
                operations++;
            }
            StringBuilder sb = new StringBuilder("-123");
            Integer.parseInt(sb.toString(), 1, sb.length(), 10);
        }
        return operations;
    }
}

package com.splabs.lib;

import java.util.Arrays;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    // return all possible non-duplicate combinations of input
    public List<String> allStrings(String input) {
        Set<String> ans = new HashSet<>();
        combine(input.toCharArray(), ans, "");
        List<String> list = new LinkedList<>(ans);
        return list;
    }

    public void combine(char[] input, Set<String> result, String accumulated) {
        System.out.println(Arrays.asList(input));
        if (input.length < 2) {
            result.add(accumulated + new String(input));
            return;
        }
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            char[] more = new char[input.length - 1];
            int i0 = 0;
            for (int j = 0; j < input.length; j++) {
                if(j!=i) {
                    more[i0] = input[j];
                    i0++;
                }
            } ;
            combine(more, result, accumulated + c);
        }
    }
}

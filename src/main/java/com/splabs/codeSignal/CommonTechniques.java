package com.splabs.codeSignal;

import java.util.HashSet;
import java.util.Set;

public class CommonTechniques {
    public boolean containsDuplicates(int[] a) {
        Set<Integer> nums = new HashSet<>();
    for(int n : a) {
        if(nums.contains(n)) {
            return true;
        }
        nums.add(n);
    }
    return false;
    }
}

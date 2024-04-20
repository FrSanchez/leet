package com.splabs.leet.Strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problems {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(set.size(), maxLen);
            } else {
                char last = '\0';
                do {
                    last = s.charAt(start++);
                    if (last != c) {
                        set.remove(last);
                    }
                } while (last != c && start <= i);
            }
        }
        return maxLen;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sz = nums1.length + nums2.length;
        int midIndex = sz / 2;
        int n1 = 0, n2 = 0;
        int[] merged = new int[midIndex+1];
        int i = 0;
        for(; i <= midIndex && n1 < nums1.length && n2 < nums2.length; i++) {
            if (nums1[n1] < nums2[n2]) {
                merged[i] = nums1[n1++];
            } else {
                merged[i] = nums2[n2++];
            }
        }
        while(i <= midIndex && n1 < nums1.length) {
            merged[i++] = nums1[n1++];
        }
        while(i <= midIndex && n2 < nums2.length) {
            merged[i++] = nums2[n2++];
        }

        if( sz % 2 == 0) {
            return (double)(merged[midIndex] + merged[midIndex-1]) / 2.0f;
        }
        return (double)merged[midIndex];
    }

}

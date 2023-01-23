package com.splabs.leet.Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class Sorting {
    int[] solution(int[] a) {
        int[] clone = a.clone();
        
        Arrays.sort(clone);
        int idx = 0;
        for (idx = 0; idx < clone.length && clone[idx] == -1; idx++) {}
        if (idx < a.length) {
            for(int i = 0; i < a.length; i++) {
                if (a[i] != -1) {
                    a[i] = clone[idx];
                    idx++;
                }
            }
        }
        return a;
    }
    
    /*
     * Write a function that reverses characters in (possibly nested) parentheses in the input string.

Input strings will always be well-formed with matching ()s.
     */
    String reverseInParenthesis(String inputString) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0 ; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '(') {
                count++;
                if (count==1) {
                    ans.append(sb);
                } else {
                    stack.push(sb.toString());
                }
                sb.setLength(0);
            } else 
            if (inputString.charAt(i) == ')') {
                count--;
                if (!stack.isEmpty()) {
                    sb.reverse();
                    sb.insert(0, stack.pop());
                } else {
                    ans.append(sb.reverse());
                    sb.setLength(0);
                }
            } else {
                sb.append(inputString.charAt(i));
            }
        }
        ans.append(sb);
        return ans.toString();
    }

    String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}

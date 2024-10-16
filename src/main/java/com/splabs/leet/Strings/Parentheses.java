package com.splabs.leet.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        return answer;
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c=='(') {
                stack.push(i);
            }
            if (c==')' && !stack.isEmpty()) {
                arr[stack.pop()]=1;
                arr[i]=1;
            }
        }
        int ans = 0;
        int temp = 0;
        for(int num : arr) {
            if (num==1) {
                temp++;
                ans = Math.max(ans, temp);
            } else {
                temp=0;
            }
        }
        return ans;
    }
}

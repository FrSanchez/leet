package com.splabs.leet.Strings;

import java.util.Stack;

public class ReverseParenthesis {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb);
                sb = new StringBuilder();
                continue;
            }
            if (c == ')') {
                var last = stack.pop();
                last.append(sb.reverse());
                sb = last;
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

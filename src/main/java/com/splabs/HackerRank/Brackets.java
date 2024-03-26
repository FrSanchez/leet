package com.splabs.HackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Brackets {

    public static class Data {
        private Character type;
        private Integer count;

        public Character getType() {
            return type;
        }

        public void setType(Character type) {
            this.type = type;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Data(char type, int count) {
            this.type = type;
            this.count = count;
        }
    }

    public static String BoolToString(boolean val) {
        return val ? "YES" : "NO";
    }
    public static String isBalanced(String s) {
        if (s.isEmpty()) {
            return BoolToString(true);
        }
        // Write your code here
        String open = "({[";
        String close = ")}]";
        Stack<Data> stack = new Stack<>();
        int count = 0;
        char type = '\0';
        for(char c : s.toCharArray()) {
            if (open.indexOf(c) >= 0) {
                if (type == '\0') {
                    type = c;
                    count = 1;
                } else {
                    if (type == c) {
                        count++;
                    } else {
                        stack.push(new Data(type, count));
                        type = c;
                        count = 1;
                    }
                }
            }
            int idx = close.indexOf(c);
            if (idx >= 0) {
                if (type == open.charAt(idx)) {
                    count--;
                    if (count == 0) {
                        if (!stack.empty()) {
                            Data d= stack.pop();
                            type = d.getType();
                            count = d.getCount();
                        } else {
                            type = '\0';
                        }
                    }
                } else {
                    return BoolToString(false);
                }
            }
        }
        return BoolToString(count == 0);
    }
}

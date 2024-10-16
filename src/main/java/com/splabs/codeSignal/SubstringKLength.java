package com.splabs.codeSignal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SubstringKLength {

    public int solution(String s, int K) {
        if (s.length() == 0) {
            return 0;
        }
        System.out.printf(">%s %d\n",s, K);
        var chars = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int maxlen = 1;
        chars.put(s.charAt(0), 1);
        while(start < s.length() && end < s.length()) {
            end++;
            if (end < s.length()) {
                char c = s.charAt(end);
                var l = (chars.containsKey(c) && chars.keySet().size() <= K);
                var r = (!chars.containsKey(c) && chars.keySet().size() < K);
                if (l || r) {
                    chars.put(c, chars.getOrDefault(c, 0) + 1);
                    int len = end - start + 1;
                    if (len > maxlen) {
                        maxlen = len;
                    }
                } else {
                    chars.put(c, chars.getOrDefault(c, 0) + 1);
                    do {
                        c = s.charAt(start);
                        chars.put(c, chars.getOrDefault(c, 0) - 1);
                        if (chars.get(c) < 1) {
                            chars.remove(c);
                        }
                        start++;
                    } while(chars.keySet().size() > K);
                }
            } else {
                break;
            }
        }
        return maxlen;
    }
}

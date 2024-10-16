package com.splabs.codeSignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Alphaland {
    public List<Integer> solution(String s) {
        System.out.println(s);
        var answer = new ArrayList<Integer>();
        var lastSeen = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastSeen.put(c, i);
        }
        int start = 0;
        int maxLast = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen.get(c) > maxLast) {
                maxLast = lastSeen.get(c);
            }
            if (i == maxLast) {
                answer.add(i - start + 1);
                start = i + 1;
            }
        }
        return answer;
    }
}

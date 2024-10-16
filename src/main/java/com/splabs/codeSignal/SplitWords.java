package com.splabs.codeSignal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SplitWords {

    public Map.Entry<Character, Integer> solution(String s) {
        var parts = s.split(" +");
        System.out.println(Arrays.toString(parts));
        var words = new HashSet<String>(Arrays.asList(parts));
        var map = new HashMap<Character, Integer>();
        int maxBreaks = -1;
        char heroC = '\0';
        for(int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            int breaks = 0;
            if (!map.containsKey(c)) {
                for(var word : words) {
                    if(word.indexOf(c) >= 0) {
                        System.out.print(word + ",");
                        breaks++;
                    }
                }
                System.out.printf("\n%c breaks %d\n",c,breaks);
                map.put(c, breaks);
                if (breaks > maxBreaks) {
                    maxBreaks = breaks;
                    heroC = c;
                }
            }
        }
        System.out.printf("[%c,%d]\n", heroC, maxBreaks);
        return Map.entry(heroC, maxBreaks);
    }
}

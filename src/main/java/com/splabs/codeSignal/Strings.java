package com.splabs.codeSignal;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    public String findEmailDomain(String address) {
            return address.substring(address.lastIndexOf("@"));
    }

    public String buildPalindrome(String st) {
        StringBuilder sb = new StringBuilder(st);
        int left = 0; 
        int last = sb.length();
        while(!isPalidrome(sb)) {
            if (last < sb.length()) {
                sb.append(st.charAt(left));
            } else {
                sb.insert(last, st.charAt(left));
            }
            left++;
        }
        return sb.toString();
    }

    private boolean isPalidrome(CharSequence s) {
        int last = s.length() - 1;
        for(int i = 0; i < last; i++, last--) {
            if (s.charAt(i) != s.charAt(last)){
                return false;
            }
        }
        return true;
    }

    public String mergeStrings(String s1, String s2) {
        Map<Character, Integer> m1 = createMap(s1);
        Map<Character, Integer> m2 = createMap(s2);
        StringBuilder sb = new StringBuilder();
        int len = s1.length() + s2.length();
        int i1 = 0;
        int i2 = 0;
        for(int i = 0; i < len && i1 < s1.length() && i2 < s2.length(); i++) {
            char c1 = s1.charAt(i1);
            char c2 = s2.charAt(i2);
            if (m1.get(c1) < m2.get(c2)) {
                sb.append(c1); i1++;
            }
            if (m1.get(c1) > m2.get(c2)) {
                sb.append(c2); i2++;
            }
            if ( (int) m1.get(c1) == (int)m2.get(c2)) {
                if (c1 <= c2) {
                    sb.append(c1); i1++;
                } else {
                    sb.append(c2); i2++;
                }
            }
        }
        for(; i1 < s1.length(); i1++) {
            sb.append(s1.charAt(i1));
        }
        for(; i2 < s2.length(); i2++) {
            sb.append(s2.charAt(i2));
        }
        return sb.toString();
    }

    Map<Character, Integer> createMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
}

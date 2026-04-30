package com.splabs.leet.Strings;

public class MergeCharacters {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        int st = 0;
        for(int i = 0 ; i < s.length(); i++ ){
            char c = s.charAt(i);
            int idx = c - 'a';
            if (count[idx] > 0) {
                continue;
            }
            sb.append(c);
            count[idx]++;
            if (sb.length() >= k) {
                char d = sb.charAt(st);
                st++;
                count[d-'a']--;
            }
        }
        return sb.toString();
    }
}

package com.splabs.leet.Strings;

import java.util.HashMap;
import java.util.Map;

public class Ransom {

    private Map<Character, Integer> buildMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character charAt : input.toCharArray()) {
            if (Character.isAlphabetic(charAt)) {
                Character c = Character.toLowerCase(charAt);
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
        }
        return map;
    }

    private Boolean isContained(Map<Character, Integer> magazine, Map<Character, Integer> text) {
        for(Character key : text.keySet()) {
            if (!magazine.containsKey(key)) {
                return false;
            }
            if (magazine.get(key) < text.get(key)) {
                return false;
            }
        }
        return true;
    }
    public Boolean IsBuildable(String magazine, String text) {
        Map<Character, Integer> mMap = buildMap(magazine);
        Map<Character, Integer> tMap = buildMap(text);
        return isContained(mMap, tMap);
    }
}

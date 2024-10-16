package com.splabs.leet.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PhoneNumbersString {
    private final Character[][] letters = {
            {},  // 0
            {},  // 1
            {'a', 'b', 'c'}, // 2
            {'d', 'e', 'f'}, // 3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'},//7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'}//9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (!digits.isEmpty()) {
            combine(new StringBuilder(), digits, 0, ans);
        }
        return ans;
    }

    private void combine(StringBuilder current, String digits, int idx, List<String> output) {
        if (idx >= digits.length()) {
            output.add(current.toString());
            return;
        }
        int digit = digits.charAt(idx) - '0';
        if (letters[digit].length == 0) {
            combine(current, digits, idx+1, output);
        } else {
            for (char c : letters[digit]) {
                int l = current.length();
                current.append(c);
                combine(current, digits, idx + 1, output);
                current.setLength(l);
            }
        }
    }

}

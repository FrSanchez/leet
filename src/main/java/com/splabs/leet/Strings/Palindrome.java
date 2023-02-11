package com.splabs.leet.Strings;

public class Palindrome {
    /*&
 You are given a string s. Consider the following algorithm applied to this string:

Take all the prefixes of the string, and choose the longest palindrome between them.
If this chosen prefix contains at least two characters, cut this prefix from s and go back to the first step with the updated string. Otherwise, end the algorithm with the current string s as a result.
Your task is to implement the above algorithm and return its result when applied to string s.

Note: you can click on the prefixes and palindrome words to see the definition of the terms if you're not familiar with them.
     */
    public String extractPrefix(String s) {
        System.out.println(s);
        if (s.length() < 2) {
            return s;
        }
        for(int end = s.length() - 1; end >= 1; end--) {
            if (isPalindrome(s, 0, end)) {
                if (end >= 1) {
                    return extractPrefix(s.substring(end + 1));
                } else {
                    return s;
                }
            }
        }
        return s;
    }

    boolean isPalindrome(String s, int start, int end) {
        System.out.println(s.substring(start, end));
        if (start > end || end >= s.length()) {
            return false;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }


}

package com.splabs.meta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encoder {

    public static String decode(String input) {
        if (input.isEmpty()) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        String regex = "([0-9]+)([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.groupCount() == 2) {
                try {
                    int count = Integer.parseUnsignedInt(matcher.group(1));
                    if (count > 0) {
                        sb.append(matcher.group(2).repeat(count));
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Number not supported");
                }
            }
        }
        return sb.toString();
    }
    public static String encode(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char last = '\0';
        for(char c : input.toCharArray()) {
            if (c!=last) {
                if (count > 0) {
                    sb.append(count);
                    sb.append(last);
                }
                count = 1;
                last = c;
            } else {
                count++;
            }
        }
        if (count > 0) {
            sb.append(count);
            sb.append(last);
        }
        return sb.toString();
    }
}

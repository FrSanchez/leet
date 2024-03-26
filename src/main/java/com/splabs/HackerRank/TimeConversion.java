package com.splabs.HackerRank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {
    public static String timeConversion(String s) {
        Pattern pattern = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})([AP]M)");
        Matcher matcher = pattern.matcher(s);
        String hr = "";
        String mn = "";
        String sc = "";
        String ap = "";
        if (matcher.find() ) {
            hr = matcher.group(1);
            mn = matcher.group(2);
            sc = matcher.group(3);
            ap = matcher.group(4);

            int hour = Integer.parseInt(hr);
            if (ap.equalsIgnoreCase("pm")) {
                if (hour < 12) {
                    hour += 12;
                }
                hr = String.format("%2d",hour);
            } else {
                if (hour == 12) {
                    hour = 0;
                }
            }
            hr = String.format("%02d",hour);
        }
        return String.format("%s:%s:%s",hr,mn,sc);
    }
}

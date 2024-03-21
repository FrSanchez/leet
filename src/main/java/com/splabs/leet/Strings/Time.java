package com.splabs.leet.Strings;

public class Time {
    public String timeConversion(String s) {
        String [] parts = s.split(":");
        String ampm = parts[2].substring(2);
        int hour = Integer.parseInt(parts[0]);
        if (ampm.compareToIgnoreCase("AM") == 0 && parts[0].compareTo("12")==0) {
            hour=0;
        }
        if (ampm.compareToIgnoreCase("PM") == 0){
            if (hour!=12) {
                hour+=12;
            }
        }
        return String.format("%02d:%s:%s", hour,parts[1],parts[2].substring(0,2));
    }

}

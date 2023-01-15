package com.splabs.leet.Strings;

public class IP {
    public boolean isValid(String inputString) {
        boolean maybe = inputString.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}");
        
        if (maybe) {
            String[] parts = inputString.split("\\.");
            if (parts.length == 4) {
                for(String p : parts) {
                    int v = Integer.parseInt(p);
                    if (v<1 || v>255) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}


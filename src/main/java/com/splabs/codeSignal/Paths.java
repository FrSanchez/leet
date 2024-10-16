package com.splabs.codeSignal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paths {
    private String normalizePath(String path) {
        String[] parts = path.split("/");
        List<String> normalizedParts = new ArrayList<>();
        for(String part : parts) {
            if(part.equals("..")) {
                if(!normalizedParts.isEmpty()) {
                    normalizedParts.remove(normalizedParts.size() - 1);
                }
            } else if(!part.equals(".") && !part.isEmpty()) {
                normalizedParts.add(part);
            }
        }
        return String.join("/", normalizedParts);
    }

    private String commonSuffix(String left, String right) {
        String[] lparts = left.split("/");
        String[] rpaths = right.split("/");
        int l = lparts.length - 1;
        int r = rpaths.length - 1;
        if (l == 0 || r == 0) {
            return "";
        }
        StringBuilder suffix = new StringBuilder();
        while (l >= 0 && r >= 0 && lparts[l].equals(rpaths[r])) {
            suffix.insert(0, "/"  + lparts[l] );
            l--;
            r--;
        }
        if (r > 0 && l > 0) {
            suffix.insert(0, rpaths[r]);
        }
        return suffix.toString();
    }

    public String commonSuffix(String[] paths) {
        List<String> pathList = new ArrayList<>();
        String last = null;
        for(String path : paths) {
            System.out.println("path: " + path + " last: " + last);
            String normalizedPath = normalizePath(path);
            if (last != null) {
                last = commonSuffix(last, normalizedPath);
                System.out.println("last: " + last);
                if (last.equalsIgnoreCase("")) {
                    return "";
                }
            } else {
                last = normalizedPath;
            }
            pathList.add(normalizedPath);
        }
        return last;
    }
}

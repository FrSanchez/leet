package com.splabs.leet.Strings;

public class Zigzag {
    public String convert(String s, int numRows) {
        if (numRows <2) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        int row = 0; int dir = 1;
        for(int i = 0; i < s.length(); i++) {
            if (sb[row] == null) {
                sb[row] = new StringBuilder();
            }
            sb[row].append(s.charAt(i));
            row += dir;
            if (row >= numRows) {
                dir = -1;
                row = numRows - 2;
            }
            if (row < 0) {
                dir = 1;
                row = 1;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder o : sb) {
            if (o!=null) {
                ans.append(o.toString());
            }
        }
        return ans.toString();
    }
}

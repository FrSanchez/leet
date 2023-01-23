package com.splabs.codeSignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test {
    public int serverPowers(int[] serverPowers, String[] events) {
        int[] state = new int[serverPowers.length];
        int[] tally = new int[serverPowers.length];
        Set<Integer> failed = new HashSet<>();
        int curr = 0;
        int max = 0;
        for (String e : events) {
            if (e.startsWith("REQUEST")) {
                while(state[curr] >= serverPowers[curr] || failed.contains(curr)) {
                    curr++;
                    if (curr >= state.length) {
                        curr=0;
                        Arrays.fill(state, 0);
                    }
                }
                state[curr]++;
                tally[curr]++;
                if(tally[curr] > max) {
                    max = tally[curr];
                }
            }
            if (e.startsWith("FAIL")) {
                String[] parts = e.split(" ");
                int f = Integer.parseInt(parts[1]);
                failed.add(f);
            }
            printArr(state);
            printArr(tally);
            
        }
        for(int i = state.length - 1; i >=0; i--) {
            if (tally[i] == max) {
                return i;
            }
        }
        return -1;
    }

    private void printArr(int[] arr) {
        System.out.printf("[");
        for(int i =0; i < arr.length; i++) {
            System.out.printf("%c%d",i == 0 ? ' ' : ',', arr[i]);
        }
        System.out.println("]");
    }

    public String commonPaths(String[] paths) {
        if (paths.length < 2) {
            return "";
        }
        List<List<String>> list = new LinkedList<>();
        for (String p : paths) {
            list.add(normalize(p));
        }
        List<String> common = new LinkedList<>(list.get(0));
        for (int i = 1; i < paths.length; i++) {
            common = getCommonSuffix(common, list.get(i));
            if (common.size() == 0) {
                return "";
            }
        }
        return "/" + String.join("/", common);
    }

    public List<String> getCommonSuffix(List<String> p0, List<String> p1) {
        List<String> common = new LinkedList<>();
        int j = p1.size() - 1;
        for (int i = p0.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (p0.get(i).compareTo(p1.get(j)) == 0) {
                common.add(0, p0.get(i));
            } else {
                i = -1;
                j = -1;
            }
        }
        return common;
    }

    private List<String> normalize(String path) {
        List<String> simpl = new LinkedList<>();
        String[] parts = path.split("/");
        for (String p : parts) {
            if (p.compareTo("..") == 0) {
                simpl.remove(simpl.size() - 1);
            } else {
                simpl.add(p);
            }
        }

        return simpl;
    }
}

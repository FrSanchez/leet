package com.splabs.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permutations {
    // given an integer n, and integer k
    // return the permutation sequence of the set [1,2,3,...,n]
    // the permutations are ordered lexicographically


    public String solution(int n, int k) {
        int [] fact = new int[n+1];
        fact[0] = 1;

        List<Integer> rem = new ArrayList<>();
        for(int i = 1; i <=n ; i++) {
            fact[i] = fact[i - 1] * i;
            rem.add(i);
        }
        System.out.println(rem);
        System.out.println(Arrays.toString(fact));

        k--;
        StringBuilder sb = new StringBuilder();

        for(int sz = n; sz >= 1; sz--) {
            int bs = fact[sz - 1];
            int index = k /bs;

            sb.append(rem.remove(index));
            k %= bs;
        }

        return sb.toString();
    }
    boolean [] vis = new boolean[10];
    int count;
    String ans;
    public void dfs(int n, int c, int k, StringBuilder sb) {
        if (count >= k) {
            return;
        }
        vis[c] = true;
        sb.append(c);
        boolean f = false;
        for(int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(n, i, k, sb);
                f = true;
            }
        }
        if (!f) {
            count++;
            if (count == k) {
                ans = sb.toString();
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        vis[c] = false;
    }

    public String dfs_style(int n, int k) {
        ans = "";
        for(int i = 1; i <= n; i++ ) {
            vis = new boolean[10];
            dfs(n, i, k, new StringBuilder());
            if (!ans.isEmpty()) {
                return ans;
            }
        }
        return ans;
    }
}

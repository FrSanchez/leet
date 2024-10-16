package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class RearrageLastN {
    ListNode solution(ListNode l, int n) {
        ListNode start = l;
        ListNode end = l;
        for(int c = 0; c < n; c++, end = end.next) { }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        if (start == l) {
            return start;
        }
        end.next = l;
        start.next = null;
        return start;
    }
}


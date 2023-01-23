package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class RearrageLastN {
    ListNode<Integer> solution(ListNode<Integer> l, int n) {
        ListNode<Integer> start = l;
        ListNode<Integer> end = l;
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


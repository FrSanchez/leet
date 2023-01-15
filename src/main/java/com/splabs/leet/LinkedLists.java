package com.splabs.leet;

public class LinkedLists {
    ListNode<Integer> removeAllK(ListNode<Integer> l, int k) {
        while (l !=null && l.value == k) {
            l = l.next;
        }
        if (l == null) {
            return null;
        }
        ListNode<Integer> answer = l;
        ListNode<Integer> prev = l;
        l=l.next;
        for(; l != null; prev = l, l = l.next) {
            if (l.value == k) {
                prev.next = l.next;
            }        
        }
        return answer;
    }
}

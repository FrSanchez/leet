package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class Merge {

    ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode<Integer> head = l1;
        while(l1 != null && l2 != null) {
            if (l2.value < l1.value) {
                ListNode<Integer> t = l2;
                l2 = l2.next;
                t.next = l1;
                if (l1 == head) {
                    head = t;
                }
                l1 = t;
            } else {       
            l1 = l1.next;
            }
        }
        if (l2 != null)  {
            l1.next = l2;
        }
        return head;
    }
 
}

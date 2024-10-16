package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class MergeSortedLists {
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = null;

        boolean allNull = false;
        do {
            allNull = true;
            for (int i = 0; i < lists.length; i++) {
                ListNode curr = lists[i];
                if (curr == null) {
                    continue;
                }
                allNull = false;
                if (answer == null || curr.value >= answer.value) {
                    answer = curr;
                    lists[i] = curr.next;
                    answer.next = null;
                } else {
                    ListNode prev = null;
                    ListNode next = answer;
                    while (next != null && curr.value <= next.value) {
                        prev = next;
                        next = next.next;
                    }
                    prev.next = curr;
                    lists[i] = curr.next;
                    curr.next = next;
                }
            }
        } while (!allNull);
        return answer;
    }
}
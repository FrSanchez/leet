package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && curr.next !=null) {
            if (prev == null) {
                ans = curr.next;
                prev = curr.next.next;
                ans.next = curr;
                curr.next = prev;
            } else {
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = curr;
            }
            prev = curr;
            curr = curr.next;
        }
        return ans;
    }

    private boolean hasK(ListNode head, int k) {
        for(int i = 1; i < k && head != null; i++) {
            head = head.next;
        }
        return head != null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        String s= "";

        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = null;
        ListNode last = head;
        while(head != null && hasK(head, k)) {
            ListNode list = null;
            for(int i = 0; i < k && head != null; i++) {
                ListNode next = head.next;
                head.next = list;
                list = head;
                head = next;
            }
            if (ans == null) {
                ans = list;
            } else {
                last.next = list;
                for(int i = 0; i < k && last.next != null; i++) {
                    last = last.next;
                }
            }
        }
        if (head != null && last != null) {
            last.next = head;
        }
        return ans;
    }
}

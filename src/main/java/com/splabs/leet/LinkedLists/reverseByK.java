package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class reverseByK {
    // Singly-linked lists are already defined with this interface:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode solution(ListNode l, int k) {
        if (k==1) {
            return l;
        }
        ListNode head = null;
        ListNode answer = null;
        ListNode tk = null;
        int count = 0;
        while(l != null) {
            count++;
            // System.out.printf("%d cnt %d\n", l.value, count);
            if (count <= k) {
                // create new list in reverse
                ListNode temp = l;
                l = l.next;
                temp.next = tk;
                tk = temp;
            } else {
                // add new list to the answer
                count = 0;
                if (answer == null) {
                    answer = tk;
                    head = answer;
                } else {
                    while (head.next != null) { head = head.next; }
                    head.next = tk;
                }
                tk = null;
            }
        }
        System.out.println(tk);
        if (tk != null) {
            if (answer == null) {
                return reverse(tk);
            }
            // if remaining, reverse to left it unchanged
            head = answer;
            while (head.next != null) { head = head.next; }
            if (count == k) {
                head.next = tk;
            } else {
                head.next = reverse(tk);
            }
        }
        return answer;
    }

    ListNode reverse(ListNode list)
    {
        ListNode sol = null;
        while(list != null) {
            ListNode temp = list;
            list = list.next;
            temp.next = sol;
            sol = temp;
        }
        return sol;
    }
}


package com.splabs.leet.LinkedLists;

import com.splabs.leet.ListNode;

public class Sum {
        // Singly-linked lists are already defined with this interface:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode solution(ListNode a, ListNode b) {
        System.out.println(a);
        System.out.println(b);
        ListNode lh = reverse(a);
        ListNode rh = reverse(b);
        System.out.println(lh);
        System.out.println(rh);
        ListNode sol = null;
        int carry = 0;
        while(lh != null && rh != null) {
            int sum = lh.value + rh.value + carry;
            ListNode curr = new ListNode(sum % 10000);
            carry = sum / 10000;
            curr.next = sol;
            sol = curr;
            System.out.printf("%d %d %d %d\n", lh.value, rh.value, sum, carry);
            lh = lh.next; 
            rh = rh.next;
        }
        while(lh != null) {
            int sum = lh.value + carry;
            ListNode curr = new ListNode(sum % 10000);
            carry = sum / 10000;
            curr.next = sol;
            sol = curr;
            lh = lh.next;
        }
        while(rh != null) {
            int sum = rh.value + carry;
            ListNode curr = new ListNode(sum % 10000);
            carry = sum / 10000;
            curr.next = sol;
            sol = curr;
            rh = rh.next;
        }
        if (carry > 0) {
            ListNode curr = new ListNode(carry);
            curr.next = sol;
            sol = curr;
        }
        return sol;
    }

    ListNode reverse(ListNode list)
    {
        ListNode head = null;
        while(list != null) {
            ListNode temp = list;
            list = list.next;
            temp.next = head;
            head = temp;
        }    
        return head;
    }

}

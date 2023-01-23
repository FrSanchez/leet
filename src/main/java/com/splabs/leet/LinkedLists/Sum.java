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
    ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        System.out.println(a);
        System.out.println(b);
        ListNode<Integer> lh = reverse(a);
        ListNode<Integer> rh = reverse(b);
        System.out.println(lh);
        System.out.println(rh);
        ListNode<Integer> sol = null;
        int carry = 0;
        while(lh != null && rh != null) {
            int sum = lh.value + rh.value + carry;
            ListNode<Integer> curr = new ListNode<Integer>(sum % 10000);
            carry = sum / 10000;
            curr.next = sol;
            sol = curr;
            System.out.printf("%d %d %d %d\n", lh.value, rh.value, sum, carry);
            lh = lh.next; 
            rh = rh.next;
        }
        while(lh != null) {
            int sum = lh.value + carry;
            ListNode<Integer> curr = new ListNode<Integer>(sum % 10000);
            carry = sum / 10000;
            curr.next = sol;
            sol = curr;
            lh = lh.next;
        }
        while(rh != null) {
            int sum = rh.value + carry;
            ListNode<Integer> curr = new ListNode<Integer>(sum % 10000);
            carry = sum / 10000;
            curr.next = sol;
            sol = curr;
            rh = rh.next;
        }
        if (carry > 0) {
            ListNode<Integer> curr = new ListNode<Integer>(carry);
            curr.next = sol;
            sol = curr;
        }
        return sol;
    }

    ListNode<Integer> reverse(ListNode<Integer> list)
    {
        ListNode<Integer> head = null;
        while(list != null) {
            ListNode<Integer> temp = list;
            list = list.next;
            temp.next = head;
            head = temp;
        }    
        return head;
    }

}

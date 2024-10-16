package com.splabs.leet;

public class ListNode implements Comparable<ListNode>
{
    public ListNode(int x) {
        value = x;
    }

    public int value;
    public ListNode next;

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode h = this;
        boolean first = true;
        while (h != null) {
            if (!first) {
                sb.append(',');
            }
            sb.append(h.value);
            first = false;
            h = h.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static ListNode toList(int[] a) {
        ListNode curr = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode next = new ListNode(a[i]);
            next.next = curr;
            curr = next;
        }
        ;
        return curr;
    }

    @Override
    public int compareTo(ListNode listNode) {
        ListNode left = this;
        ListNode right = listNode;
        while (left != null && right != null) {
            if (left.value != right.value) {
                return left.value - right.value;
            }
            left = left.next;
            right = right.next;
        }
        if (left == null && right == null) {
            return 0;
        }
        if (left == null) {
            return -1;
        }
        return 1;
    }
}

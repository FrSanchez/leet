package com.splabs.leet;

public class ListNode<T> {
    public ListNode(T x) {
        value = x;
    }
    
    public T value;
    public ListNode<T> next;

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode<T> h = this;
        boolean first = true;
        while(h!=null) {
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
}

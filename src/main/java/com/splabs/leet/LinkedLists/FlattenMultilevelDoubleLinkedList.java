package com.splabs.leet.LinkedLists;

import java.util.Stack;

/*
You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.


 */
public class FlattenMultilevelDoubleLinkedList {
    public Node flatten(Node head) {
        if (head == null || (head.next == null && head.child == null)) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        Node last = null;
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            curr.prev = last;
            if (last == null) {
                head = curr;
            }
            if (curr.next != null) {
                stack.add(curr.next);
            }
            if (curr.child != null) {
                stack.add(curr.child);
            }
            curr.child = null;
            if (last != null) {
                last.next = curr;
            }
            last = curr;
        }
        return head;
    }
}

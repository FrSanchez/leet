package com.splabs.lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapTest {
    @Test
    public void testInOrder() {
        Heap heap = new Heap();
        heap.enQueue(3);
        heap.enQueue(5);
        heap.enQueue(8);
        heap.enQueue(10);
        heap.enQueue(20);
        heap.enQueue(15);
        heap.enQueue(18);
        heap.inOrder();
    }

    @Test
    public void insertHigher() {
        Heap heap = new Heap(10);
        for(int n : new int[] { 3, 7, 6, 9, 8, 10, 18, 26, 17, 15}) {
            heap.enQueue(n);
        }
        heap.enQueue(5);
        Assertions.assertEquals(3, heap.peek());
    }

    @Test
    public void remove() {
        Heap heap = new Heap(10);
        for(int n : new int[] { 3, 5, 6, 9, 7, 10, 18, 26, 17, 15, 8}) {
            heap.enQueue(n);
        }
        int next = heap.deQueue();
        Assertions.assertEquals(5, heap.peek());
        Assertions.assertEquals(3, next);
    }
}

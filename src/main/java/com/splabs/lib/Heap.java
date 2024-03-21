package com.splabs.lib;

import java.util.List;
import java.util.ArrayList;

public class Heap {

    List<Integer> data;
    int empty;
    public Heap() {
        this(32);
    }
    public Heap(int initialSize) {
        data = new ArrayList<>(initialSize);
        empty = 0;
    }

    private int parent(int pos) {
        return ((pos+1) / 2) - 1;
    }

    private int left(int pos) {
        return ((pos+1) * 2) - 1;
    }

    private int right(int pos) {
        return ((pos+1) * 2);
    }

    private void swap(int p1, int p2) {
        int number = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2, number);
    }

    private void bubbleUp(int pos) {
        int parent = parent(pos);
        while(parent >= 0 && data.get(parent) > data.get(pos)) {
            swap(pos, parent);
            pos = parent;
            parent = parent(pos);
        }
    }

    private void bubbleDown(int pos) {
        while (pos < empty) {
            int left = left(pos);
            int right = right(pos);
            int num = data.get(pos);
            if (left >= empty) {
                return;
            }
            int lValue = data.get(left);
            if (right >= empty && lValue < num) {
                swap(pos, left);
                pos = left;
            } else {
                int rValue = data.get(right);
                if (num > lValue && num > rValue) {
                    if (lValue < rValue) {
                        swap(pos, left);
                        pos = left;
                    } else {
                        swap(pos, right);
                        pos = right;
                    }
                } else {
                    if (lValue < num) {
                        swap(pos, left);
                        pos = lValue;
                    } else {
                        swap(pos, right);
                        pos = rValue;
                    }
                }
            }
        }
    }

    public int deQueue() {
        int first = data.get(0);
        swap(0, empty - 1);
        data.remove(empty-1);
        bubbleDown(0);
        return first;
    }
    public void enQueue(int number) {
        int pos = data.size();
        data.add(number);
        empty = data.size();
        bubbleUp(pos);
    }

    private void inOrder(int pos, int offset) {
        if (pos >= empty) {
            return;
        }
        String spc = "-".repeat(offset);
        System.out.print(spc);
        inOrder(left(pos), offset + 2);
        System.out.print(spc);
        System.out.println(">" + data.get(pos));
        System.out.print(spc);
        inOrder(right(pos), offset + 2);
    }

    public void inOrder() {
        inOrder(0, 0);
    }

    public int peek() {
        return data.get(0);
    }
}

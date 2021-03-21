package com.algorithm.interview.week1;

/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class Day7MyCircularDeque {

    private int[] list;
    private int contains;
    private int maxCapacity;
    private int header;
    private int end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public Day7MyCircularDeque(int k) {
        contains = 0;
        maxCapacity = k;
        header = 0;
        end = 0;
        list = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (contains == maxCapacity - 1) {
            return false;
        }

        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return list[header] == 0 ? -1 : list[header];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return list[end] == 0 ? -1 : list[end];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return contains == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return contains == maxCapacity;
    }

    public static void main(String[] args) {
        Day7MyCircularDeque day = new Day7MyCircularDeque(10);
        System.out.println(day.isFull());
        System.out.println(day.isEmpty());
    }
}

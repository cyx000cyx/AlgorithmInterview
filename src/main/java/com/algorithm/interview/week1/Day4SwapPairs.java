package com.algorithm.interview.week1;

public class Day4SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        head = first.next;
        ListNode tmp = null;
        while (first != null) {
            ListNode second = first.next;
            if (second == null) {
                break;
            }
            first.next = second.next;
            second.next = first;
            if (tmp != null) {
                tmp.next = second;
            }
            tmp = first;
            first = first.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode create = new ListNode(arr[0], null);;
        ListNode head = create;
        for (int i = 1; i < arr.length; i++) {
            create.next = new ListNode(arr[i]);
            create = create.next;
        }
        Day4SwapPairs day = new Day4SwapPairs();
        ListNode result = day.swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
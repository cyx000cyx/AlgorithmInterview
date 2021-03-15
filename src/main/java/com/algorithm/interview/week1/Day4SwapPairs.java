package com.algorithm.interview.week1;

import com.algorithm.interview.common.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Day4SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        head = first.next;
        ListNode tmp = null;
        while (first != null && first.next != null) {
            ListNode second = first.next;
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
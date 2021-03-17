package com.algorithm.interview.week1;

import com.algorithm.interview.common.BuildLinkListUtils;
import com.algorithm.interview.common.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Day5MergeTwoLists {

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode now = result;

        while(l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                now.next = l1;
                now = l1;
                l1 = l1.next;
                now.next = l2;
                now = now.next;
                l2 = l2.next;
                continue;
            }
            if (l1.val > l2.val) {
                now.next = l2;
                l2 = l2.next;
                now = now.next;
                continue;
            }

            now.next = l1;
            l1 = l1.next;
            now = now.next;
        }

        if (l1 == null) {
            now.next = l2;
        }
        if (l2 == null) {
            now.next = l1;
        }

        result = result.next;

        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = BuildLinkListUtils.buildLinkList(new int[] {1, 2, 4});
        ListNode l2 = BuildLinkListUtils.buildLinkList(new int[] {1, 3, 4});
        Day5MergeTwoLists day = new Day5MergeTwoLists();
        ListNode result = day.mergeTwoLists(l1, l2);
        System.out.println(JSON.toJSONString(result));
    }
}

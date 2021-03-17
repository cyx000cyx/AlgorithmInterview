package com.algorithm.interview.common;

import com.alibaba.fastjson.JSON;

import java.util.Random;

public class BuildLinkListUtils {

    public static ListNode buildLinkList(int[] data) {
        ListNode create = new ListNode(data[0], null);;
        ListNode head = create;
        for (int i = 1; i < data.length; i++) {
            create.next = new ListNode(data[i]);
            create = create.next;
        }
        return head;
    }

    public static ListNode geometricSequence(int total, int step) {
        int[] data = new int[total];
        int start = 1;
        for (int i = 0; i < total; i++) {
            start *= step;
            data[i] = start;
        }
        return buildLinkList(data);
    }

    public static ListNode arithmeticProgression(int total, int step) {
        int[] data = new int[total];
        for (int i = 0; i < total; i++) {
            data[i] = step*i;
        }
        return buildLinkList(data);
    }

    public static ListNode randomList(int total, int max, boolean hasMinus) {
        Random random = new Random();
        int[] data = new int[total];
        for (int i = 0; i < total; i++) {
            int rd = random.nextInt(max);
            data[i] = hasMinus ? (random.nextBoolean() ? -rd : rd) : rd;
        }
        return buildLinkList(data);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(BuildLinkListUtils.arithmeticProgression(10, 2)));
        System.out.println(JSON.toJSONString(BuildLinkListUtils.geometricSequence(10, 2)));
        System.out.println(JSON.toJSONString(BuildLinkListUtils.randomList(10, 12, false)));
    }
}

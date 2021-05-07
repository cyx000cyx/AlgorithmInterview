package com.algorithm.interview.array;

import com.alibaba.fastjson.JSON;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class No88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, pointer = nums1.length - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[pointer--] = nums2[j--];
            } else if (j < 0) {
                nums1[pointer--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[pointer--] = nums1[i--];
            } else {
                nums1[pointer--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        No88MergeSortedArray day = new No88MergeSortedArray();
        int[] num1 = new int[]{0, 0, 0};
        day.merge(num1, 0, new int[]{1, 2, 3} , 3);
        System.out.println(JSON.toJSONString(num1));

        num1 = new int[]{1, 2, 0, 0, 0};
        day.merge(num1, 2, new int[]{1, 2, 3} , 3);
        System.out.println(JSON.toJSONString(num1));

        num1 = new int[]{1, 2, 3};
        day.merge(num1, 3, new int[]{} , 0);
        System.out.println(JSON.toJSONString(num1));

        num1 = new int[]{1,2,3,0,0,0};
        day.merge(num1, 3, new int[]{2,5,6} , 3);
        System.out.println(JSON.toJSONString(num1));

        num1 = new int[]{1,2,15,0,0,0};
        day.merge(num1, 3, new int[]{2,5,6} , 3);
        System.out.println(JSON.toJSONString(num1));
    }
}

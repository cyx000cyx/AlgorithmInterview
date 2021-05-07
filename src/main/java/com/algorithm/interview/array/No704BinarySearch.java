package com.algorithm.interview.array;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 */
public class No704BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length;

        while (end - start > 0) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                end = middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        No704BinarySearch day = new No704BinarySearch();
        int pointer = day.search(new int[]{1, 4, 10, 15, 19, 20, 24}, 19);
        System.out.println(pointer);
        pointer = day.search(new int[]{-1, 4, 10, 15, 19, 20, 24}, 15);
        System.out.println(pointer);
        pointer = day.search(new int[]{1}, 1);
        System.out.println(pointer);
        pointer = day.search(new int[]{23, 40, 98}, 19);
        System.out.println(pointer);
        pointer = day.search(new int[]{23, 40, 98}, 100);
        System.out.println(pointer);
    }
}

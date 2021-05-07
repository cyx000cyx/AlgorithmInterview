package com.algorithm.interview.array;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class No26RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                k++;
            } else {
                nums[i - k] = nums[i];
            }
        }
        return nums.length - k;
    }

    public static void main(String[] args) {
        No26RemoveDuplicates day = new No26RemoveDuplicates();
        System.out.println(day.removeDuplicates(new int[]{1, 2, 2, 3, 3}));
    }
}

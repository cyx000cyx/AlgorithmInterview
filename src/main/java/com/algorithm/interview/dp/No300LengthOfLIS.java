package com.algorithm.interview.dp;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class No300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] lis = new int[nums.length];
        int endPointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (lis[endPointer] <= nums[i]) {

            }
        }
        return 0;
    }

    public void fillIntoLISBy(int[] lis, int endPointer, int num) {

    }

    public static void main(String[] args) {
        No300LengthOfLIS day = new No300LengthOfLIS();
        int res = day.lengthOfLIS(new int[]{1, 2, 3, 4});
        System.out.println(res);
    }
}

package com.algorithm.interview.dp;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class No300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] list = new int[nums.length+1];

        Arrays.fill(list, Integer.MIN_VALUE);

        int startPointer = 1;
        int endPointer = 1;
        list[endPointer] = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (list[endPointer] < nums[i]) {
                list[++endPointer] = nums[i];
                continue;
            }

            int tempStart = startPointer;
            int tempEnd = endPointer;
            while (tempEnd >= tempStart) {
                int middle = tempStart + (tempEnd - tempStart) / 2;
                if (list[middle] > nums[i]) {
                    if (list[middle-1] < nums[i]) {
                        list[middle] = nums[i];
                        break;
                    } else {
                        tempEnd = middle;
                    }
                } else if (list[middle] == nums[i]) {
                    break;
                } else {
                    tempStart = middle + 1;
                }
            }
        }
        System.out.println(JSON.toJSONString(list));
        return endPointer;
    }

    public static void main(String[] args) {
        No300LengthOfLIS day = new No300LengthOfLIS();
        int res = 0;
        res = day.lengthOfLIS(new int[]{1, 2, 3, 4});
        System.out.println(res);
        res = day.lengthOfLIS(new int[]{4, 2, 3, 1});
        System.out.println(res);
        res = day.lengthOfLIS(new int[]{7,7,7,7,7,7,7});
        System.out.println(res);
        res = day.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18,35});
        System.out.println(res);
        res = day.lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println(res);
        res = day.lengthOfLIS(new int[]{-10,9,-2,5,3,-7,101,-18});
        System.out.println(res);
    }
}

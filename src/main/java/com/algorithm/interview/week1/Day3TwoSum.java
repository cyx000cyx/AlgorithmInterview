package com.algorithm.interview.week1;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Day3TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer other = map.get(nums[i]);
            if (other == null) {
                map.put(target - nums[i], i);
            } else {
                return new int[]{i, other};
            }
        }
        return null;
    }

    public int[] twoSumFailure(int[] nums, int target) {
        sort(nums, 0, nums.length - 1);

        int start = 0, end = nums.length -1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start += 1;
                continue;
            }
            if (nums[start] + nums[end] > target) {
                end -= 1;
                continue;
            }
            if (nums[start] + nums[end] == target) {
                return new int[] {start, end};
            }
        }

        return null;
    }

    public void sort(int[] arr, int low, int high) {
        int i,j,temp,t;
        if(low>high){
            return ;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        sort(arr, low, j-1);
        //递归调用右半数组
        sort(arr, j+1, high);
    }

    public static void main(String[] args) {
        Day3TwoSum day = new Day3TwoSum();
        int[] nums = new int[]{2,7,1,3,10,11,15};
        int[] result = day.twoSum(nums, 26);
        System.out.println(JSON.toJSONString(result));
    }
}

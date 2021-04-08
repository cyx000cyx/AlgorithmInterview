package com.algorithm.interview.week5;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class Day31RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] numsTable = new int[1001];
        int[] res = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++){
            numsTable[arr1[i]]+=1;
        }

        int j = 0;
        for(int i = 0; i < arr2.length; i++){
            while(numsTable[arr2[i]] > 0){
                res[j++] = arr2[i];
                numsTable[arr2[i]]--;
            }
        }

        for(int i = 0; i < numsTable.length; i++){
            while(numsTable[i] > 0){
                res[j++] = i;
                numsTable[i]--;
            }
        }

        return res;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> sortMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i++) {
            sortMap.put(arr2[i], 0);
        }

        int notEqualCount = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (sortMap.containsKey(arr1[i])) {
                sortMap.put(arr1[i], sortMap.get(arr1[i]) + 1);
            } else {
                arr1[notEqualCount] = arr1[i];
                notEqualCount++;
            }
        }

        sort(arr1, 0, notEqualCount-1);
        for (int i = notEqualCount - 1; i >= 0; i--) {
            arr1[arr1.length - notEqualCount + i] = arr1[i];
        }

        for (int i = 0, fillPointer = 0; i < arr2.length; i++) {
            Integer equalCount = sortMap.get(arr2[i]);
            if (equalCount != 0) {
                Arrays.fill(arr1, fillPointer, fillPointer+=equalCount, arr2[i]);
            }
        }

        return arr1;
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
        Day31RelativeSortArray day = new Day31RelativeSortArray();
        int[] arr1 = {33,22,48,4,39,36,41,47,15,45};
        int[] arr2 = {22,33,48,4};
        int[] result = day.relativeSortArray(arr1, arr2);
        System.out.println(JSON.toJSONString(result));
    }
}
package com.algorithm.interview.week1;

import com.alibaba.fastjson.JSON;

public class Day2PlusOne {
    public int[] plusOne1(int[] digits) {
        boolean needAdd = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                needAdd = false;
            }
        }
        if (needAdd) {
            int[] arr = new int[digits.length+1];
            for (int i = 0; i < digits.length; i++) {
                arr[i+1] = digits[i];
            }
            digits = arr;
        }
        int needPlus = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            if (needPlus == 0) {
                break;
            }
            if (digits[i] + needPlus > 9) {
                digits[i] = 0;
                needPlus = 1;
            } else {
                digits[i] += 1;
                needPlus = 0;
            }
        }
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int pointer = digits.length - 1;
        while (pointer >= 0 && digits[pointer] == 9) {
            digits[pointer] = 0;
            pointer -= 1;
        }
        if (pointer < 0) {
            int[] arr = new int[digits.length+1];
            arr[0] = 1;
            return arr;
        }
        digits[pointer] += 1;
        return digits;
    }

    public static void main(String[] args) {
        Day2PlusOne day = new Day2PlusOne();
        int[] result = day.plusOne(new int[]{9, 9});
        System.out.println(JSON.toJSONString(result));
    }
}

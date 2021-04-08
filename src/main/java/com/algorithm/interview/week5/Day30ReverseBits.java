package com.algorithm.interview.week5;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class Day30ReverseBits {

    public int reverseBits(long n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n % 2) == 1 || (n % 2) == -1) {
                res += 1 << (31-i);
            }
            n >>= 1;
        }
        return res;
    }

    public void getBits(long n) {
        for (int i = 0; i < 32; i++) {
            System.out.print(Math.abs(n % 2));
            n >>= 1;
        }
    }

    public static void main(String[] args) {
        Day30ReverseBits day = new Day30ReverseBits();
        int res = day.reverseBits(((long) Integer.MAX_VALUE) * 2 - 1);
        System.out.println(res);
        System.out.println();
        day.getBits((long)res);
    }
}

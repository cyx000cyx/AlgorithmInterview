package com.algorithm.interview.dp;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class No91NumDecodings {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                if (s.charAt(i) == '0') {
                    res[i+1] = res[i-1];
                } else {
                    res[i+1] = res[i] + res[i-1];
                }
            } else if (s.charAt(i) != '0') {
                res[i+1] = res[i];
            }
        }

        return res[s.length()];
    }

    public static void main(String[] args) {
        No91NumDecodings day = new No91NumDecodings();
        System.out.println(day.numDecodings("27"));
        System.out.println(day.numDecodings("1011"));
        System.out.println(day.numDecodings("2101"));
    }
}

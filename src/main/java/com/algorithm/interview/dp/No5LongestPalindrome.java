package com.algorithm.interview.dp;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class No5LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        int max = 0;
        String result = null;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i && j <= i; j++) {
                if (s.charAt(i + j) == s.charAt(i - j)) {
                    if (max < j) {
                        max = j;
                        result = s.substring(i-j, i+j);
                    }
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No5LongestPalindrome day = new No5LongestPalindrome();
        System.out.println(day.longestPalindrome("abc"));
    }
}

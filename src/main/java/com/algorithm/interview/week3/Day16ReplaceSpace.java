package com.algorithm.interview.week3;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Day16ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        char[] result = new char[s.length() + spaceCount * 2];
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) == ' ') {
                result[j++] = '%';
                result[j++] = '2';
                result[j] = '0';
            } else {
                result[j] = s.charAt(i);
            }
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Day16ReplaceSpace w = new Day16ReplaceSpace();
        String s = w.replaceSpace(" i need help ");
        System.out.println(s);
    }
}

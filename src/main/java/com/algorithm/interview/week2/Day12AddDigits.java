package com.algorithm.interview.week2;

/**
 * https://leetcode-cn.com/problems/add-digits/
 */
public class Day12AddDigits {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }

        return num;
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        Day12AddDigits day = new Day12AddDigits();
        System.out.println(day.addDigits2(10161910));
    }
}

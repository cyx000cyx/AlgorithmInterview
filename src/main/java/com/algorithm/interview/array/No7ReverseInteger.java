package com.algorithm.interview.array;

/**
 *  7. 整数反转
 *  https://leetcode-cn.com/problems/reverse-integer/
 */
public class No7ReverseInteger {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isMinus = x < 0;
        x = Math.abs(x);

        int[] arr = new int[20];
        int i = 0;
        while (x > 0) {
            arr[i++] = x - x%10;
            x /= 10;
        }

        int result = 0;
        int j = 0;
        while (i > 0) {
            result += arr[j++]*Math.pow(10, i---1);
        }

        if (result == Integer.MAX_VALUE) {
            return 0;
        }

        return (isMinus ? -1 : 1) * result;
    }

    public int reverse2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean isMinus = x < 0;
        x = Math.abs(x);

        String xString = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = xString.length() - 1; i >= 0; i--) {
            sb.append(xString.charAt(i));
        }

        long result = Long.parseLong(sb.toString());
        if (result >= Integer.MAX_VALUE) {
            return 0;
        }

        return (isMinus ? -1 : 1) * (int) result;
    }

    public int reverse3(int x) {
        if (x == 0) {
            return 0;
        }
        int largeRange = Integer.MAX_VALUE / 10;
        int smallRange = Integer.MIN_VALUE / 10;
        int result = 0;
        while (x != 0) {
            if (result > largeRange || result < smallRange) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        No7ReverseInteger day = new No7ReverseInteger();
        System.out.println(day.reverse3(12388008));
        System.out.println(day.reverse3(-123));
        System.out.println(day.reverse3(1534236469));
        System.out.println(day.reverse3(-2147483648));
        System.out.println(day.reverse3(-2147483412));
    }
}

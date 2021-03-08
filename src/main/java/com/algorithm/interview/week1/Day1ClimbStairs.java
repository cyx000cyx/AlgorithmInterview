package com.algorithm.interview.week1;

public class Day1ClimbStairs {
    public int climbStairs1(int n) {
        int fn = 1;
        if (n == 1) {
            return fn;
        }

        int fnm1 = 1;
        int fnm2 = 1;
        fn = fnm1 + fnm2;
        for (int i = 2; i < n; i++) {
            fnm2 = fnm1;
            fnm1 = fn;
            fn = fnm2 + fnm1;
        }
        return fn;
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Day1ClimbStairs d = new Day1ClimbStairs();
        for (int i = 0; i < 46; i++) {
            d.climbStairs2(i);
        }
    }
}

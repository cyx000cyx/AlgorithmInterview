package com.algorithm.interview.week1;

public class Day1ClimbStairs {
    public int climbStairs(int n) {
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

    public static void main(String[] args) {
        Day1ClimbStairs d = new Day1ClimbStairs();
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
        for (int i = 0; i < 46; i++) {
            d.climbStairs(i);
        }
        System.out.println(runtime.totalMemory());
    }
}

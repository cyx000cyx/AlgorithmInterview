package com.algorithm.interview.week5;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Day35UniquePaths {
    public int m = 0;
    public int n = 0;
    public int ways = 0;

    public int uniquePathsRubbish(int m, int n) {
        this.m = m;
        this.n = n;
        traversal(1, 1);
        return ways;
    }

    public void traversal(int nowM, int nowN) {
        if (nowM == m && nowN == n) {
            ways++;
            return ;
        } else if (nowM == m) {
            ways++;
            return ;
        } else if (nowN == n) {
            ways++;
            return ;
        }
        traversal(nowM+1, nowN);
        traversal(nowM, nowN + 1);
    }

    public int uniquePaths(int m, int n) {
        if (m + n == 0) {
            return 1;
        }
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        return arr[m-1][n-1];
    }

    public int uniquePathsGracefully(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<m; i++){
            for(int j=1;j<n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Day35UniquePaths day = new Day35UniquePaths();
        int res = day.uniquePaths(51, 9);
        System.out.println(res);
    }
}

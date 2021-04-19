package com.algorithm.interview.dp;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class No63UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean mb = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                mb = true;
            } else if (mb) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        boolean nb = false;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                nb = true;
            } else if (nb) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    public int uniquePathsWithObstaclesGracefully(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                res[i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if (j != 0) {
                    res[j] += res[j-1];
                }
            }
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        No63UniquePathsWithObstacles day = new No63UniquePathsWithObstacles();
        int[][] arr = new int[][] {
                new int[]{0, 1, 1},
                new int[]{0, 1, 0},
                new int[]{0, 1, 0},
        };
//        int[][] arr = new int[][] {
//                new int[]{1, 0}
//        };
        int res = day.uniquePathsWithObstaclesGracefully(arr);
        System.out.println(res);
    }
}

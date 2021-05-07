package com.algorithm.interview.array;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class No121MaxProfit {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;

        for (int price : prices) {
            if (min > price) {
                min = price;
                continue;
            }
            result = Math.max(result, price - min);
        }

        return result;
    }

    public static void main(String[] args) {
        No121MaxProfit day = new No121MaxProfit();
        System.out.println(day.maxProfit(new int[] {7, 8, 1, 4, 6, 0, 2}));
        System.out.println(day.maxProfit(new int[] {1, 2, 3, 8, 9, 10, 1}));
        System.out.println(day.maxProfit(new int[] {8, 7, 6, 4, 3, 1, 0}));
    }
}

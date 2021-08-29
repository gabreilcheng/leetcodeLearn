package com.cheng.learn.study04;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 时间复杂度O（N） 空间复杂度O（1）
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, (prices[i] - prices[i-1]));
        }
        return profit;
    }
}

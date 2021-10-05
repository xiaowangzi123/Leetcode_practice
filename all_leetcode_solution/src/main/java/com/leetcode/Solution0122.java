package com.leetcode;

import com.leetcode.array.Solution1122;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/9
 * @description ：买卖股票的最佳时机2
 */
public class Solution0122 {
    public static void main(String[] args) {
        Solution0122 obj = new Solution0122();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(obj.maxProfit(prices));

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(obj.maxProfit(prices2));
    }

    /**
     * 可以多次买入卖出，但再次购买前出售掉之前的股票
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

}
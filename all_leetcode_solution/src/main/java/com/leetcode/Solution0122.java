package com.leetcode;

import com.leetcode.array.Solution1122;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/9
 * @description：
 */
public class Solution0122 {
    public static void main(String[] args) {
        Solution0122 obj = new Solution0122();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
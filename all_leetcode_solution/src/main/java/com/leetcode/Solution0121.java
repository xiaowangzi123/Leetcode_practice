package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/9
 * @description :买卖股票的最佳时机
 */
public class Solution0121 {
    public static void main(String[] args) {
        Solution0121 obj = new Solution0121();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(arr));
        System.out.println(obj.maxProfit2(arr));
    }

    /**
     * 只能一次买入，一次卖出
     * 选择最小的价格买入，在最小价格后面选择一个最大的
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if ((prices[i] - min) > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }

}
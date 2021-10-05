package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/9
 * @description ：买卖股票的最佳时机3
 */
public class Solution0123 {
    public static void main(String[] args) {
        Solution0123 obj = new Solution0123();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(obj.maxProfit(prices));
        System.out.println(obj.maxProfit2(prices));

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(obj.maxProfit(prices2));
        System.out.println(obj.maxProfit2(prices2));
    }

    /**
     * 由于最多可以完成两笔交易，因此在任意一天结束之后，处于以下五个状态中的一种：
     * 1.未进行过任何操作；
     * 2.只进行过一次买操作；
     * 3.进行了一次买操作和一次卖操作，即完成了一笔交易；
     * 4.在完成了一笔交易的前提下，进行了第二次买操作；
     * 5.完成了全部两笔交易。
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * 对于任意一天考虑四个变量:
     * fstBuy: 在该天第一次买入股票可获得的最大收益
     * fstSell: 在该天第一次卖出股票可获得的最大收益
     * secBuy: 在该天第二次买入股票可获得的最大收益
     * secSell: 在该天第二次卖出股票可获得的最大收益
     * 分别对四个变量进行相应的更新, 最后secSell就是最大
     * 收益值(secSell >= fstSell)
     **/
    public int maxProfit2(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int p : prices) {
            firstBuy = Math.max(firstBuy, -p);
            firstSell = Math.max(firstSell, firstBuy + p);
            secondBuy = Math.max(secondBuy, firstSell - p);
            secondSell = Math.max(secondSell, secondBuy + p);
        }
        return secondSell;
    }

}
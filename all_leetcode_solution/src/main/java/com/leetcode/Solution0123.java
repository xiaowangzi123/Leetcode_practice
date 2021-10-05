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
     * 由于最多可以完成两笔交易
     * 动态规划：
     * 所谓动态规划，就是把复杂的问题简化成规模较小的子问题，再从简单的子问题自底向上一步一步递推，最终得到复杂问题的最优解。
     * 分析两次股票交易总共 5中状态 。
     * 0观望不买，1第一次买入，2第一次卖出，3第二次买入，4第二次卖出 。
     * 假设状态为k，所以 K的取值为[0,4]。n为第几天,最大利润为公式F(n,k)
     * 得出各种状态下最大利润的公式如下：
     * fstBuy: 在该天第一次买入股票可获得的最大收益max(F(n-1,1),-p),当天股价的负数和之前每天的第一次买入利润对比取最大值。
     *        (第一次买入最大利润应该为负数，即第一次买入股价的最小值)
     * fstSell: 在该天第一次卖出股票可获得的最大收益max(F(n-1，2),F(n-1，1)+ P)当天股价的正数 + 之前第一次买入的最大利润和之前每天的第一次卖出利润 对比取最大值。
     *        (第一次卖出最大利润应该为正数，即第一次卖出的最大值)
     * secBuy: 在该天第二次买入股票可获得的最大收益 max(F(n-1，3),F(n-1，2)- P) 当天股价的负数 + 之前第一次卖出的最大利润   和 之前每天的第二次买入利润 对比取最大值。
     * secSell: 在该天第二次卖出股票可获得的最大收益 max(F(n-1，4),F(n-1，3)+ P)当天股价的正数 + 之前第二次买入的最大利润   和 之前每天的第二次卖出利润 对比取最大值。
     * 分别对四个变量进行相应的更新, 最后secSell就是最大
     * 初始值为第一天的四个状态的值，第一次买为负股价，设为最小值，第一次卖为 0，第二次买为负股价，设为最小值，第二次卖为 0
     * 可以简单的把上述四个值理解为两次交易过程
     * buy1的值，
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
     *  初始值为第一天 的四个状态的值，第一次买 为 负股价，设为最小值，第一次卖为 0，第二次买 为 负股价，设为最小值，第二次卖为 0
     *
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
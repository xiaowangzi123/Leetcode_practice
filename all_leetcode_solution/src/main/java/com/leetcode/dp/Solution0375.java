package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/12
 * @description : 猜数字大小 II
 * 动态规划
 */
public class Solution0375 {
    public static void main(String[] args) {
        Solution0375 obj = new Solution0375();
        System.out.println(obj.getMoneyAmount(5));
    }

    /**
     * TODO
     * <p>
     * dp[i][j]表示我从[i,j]之前选择一个数字你来猜，你确保获胜所需要的最少现金
     * 转移方程：
     * dp[i][j] = min(i + dp[i + 1][j],
     * ...
     * k + max(dp[i][k - 1], dp[k + 1][j]),  (k从i + 1到j - 1)
     * ...
     * j + dp[i][j - 1]
     * )
     * 返回: dp[1][n]
     */
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for (int j = 2; j < n + 1; j++) {
            for (int i = j - 1; i > 0; i--) {
//                dp[i][j] = Math.min(i + dp[i + 1][j], j + dp[i][j - 1]);
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(k + Math.max(dp[i][k - 1], dp[k + 1][j]), dp[i][j]);
                }
                dp[i][j] = Math.min(dp[i][j], i + dp[i + 1][j]);
                dp[i][j] = Math.min(dp[i][j], j + dp[i][j - 1]);
            }
        }
        return dp[1][n];
    }


}
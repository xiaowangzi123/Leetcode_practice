package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0746 {
    public static void main(String[] args) {
        Solution0746 obj = new Solution0746();
        int[] cost = {10, 15, 20};
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(obj.minCostClimbingStairs(cost));
        System.out.println(obj.minCostClimbingStairs2(cost));

    }

    /**
     * 动态规划
     * 第i级台阶是第i-1级台阶的阶梯顶部。
     * 踏上这个台阶需要加上当前台阶值，踏上第i级台阶花费cost[i]，直接迈一大步跨过而不踏上去则不用花费。
     * 边界：
     * 1.踏上第0个台阶顶部，最小值dp[0]=0，直接两步跨过去，不用花费
     * 2.踏上第1个台阶顶部，两种方式，先踏上第0，然后跨两步，值为cost[0]；或者踏上第1个，值为cost[1]
     * 所以，dp[1]=min{cost[0],cost[1]}
     * 3.踏上第i级台阶顶部有两种方法：
     * 3.1 到达第i级台阶(第i-1级台阶的顶部)，最小花费dp[i-1]，跨一步到达i级台阶的顶部，需加上当前台阶值
     * 所以，花费dp[i-1]+cost[i]
     * 3.2 到达第i-1级台阶(第i-2级台阶的顶部)，最小花费dp[i-2],跨两步到达i级台阶顶部
     * 所以，花费dp[i-2]+cost[i-1]
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1] + cost[i]);
        }
        return dp[n - 1];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int ans = 0, a = 0, b = Math.min(cost[0], cost[1]);
        for (int i = 2; i < n; i++) {
            ans = Math.min(a + cost[i - 1], b + cost[i]);
            a = b;
            b = ans;
        }
        return ans;
    }
}
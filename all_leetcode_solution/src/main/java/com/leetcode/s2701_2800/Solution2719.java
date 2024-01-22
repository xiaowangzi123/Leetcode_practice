package com.leetcode.s2701_2800;

import java.util.*;

/**
 * 统计整数数目
 */
public class Solution2719 {
    public static void main(String[] args) {
        Solution2719 solution = new Solution2719();

        //11
        System.out.println(solution.count("1", "12", 1, 8));
        //5
        System.out.println(solution.count("1", "5", 1, 5));
        //883045899
        System.out.println(solution.count("4179205230", "7748704426", 8, 46));
    }

    private static final int MOD = 1000000007;

    public int count(String num1, String num2, int minSum, int maxSum) {
        int ans = calc(num2, minSum, maxSum) - calc(num1, minSum, maxSum) + MOD;
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (minSum <= sum && sum <= maxSum) {
            ans++;
        }
        return ans % MOD;
    }

    private int calc(String num, int minSum, int maxSum) {
        int n = num.length();
        // 每一位的记忆化存储上限是 9n 或 max_sum, 因为超过 max_sum 就过滤掉了
        // 直接记忆在 sum 位, 所以 +1
        int[][] memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 第一位一定是limit的
        int dfs = dfs(0, 0, true, num.toCharArray(), minSum, maxSum, memo);
        return dfs;
    }

    private int dfs(int i, int sum, boolean isLimit, char[] num, int minSum, int maxSum, int[][] memo) {
        // 递归求和超出上限, 停止后续计算
        if (sum > maxSum) {
            return 0;
        }
        // 递归求和进行到最后一位, 满足条件返回 1 值
        if (i == num.length) {
            return sum >= minSum ? 1 : 0;
        }
        // 记忆化存储
        if (!isLimit && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        // 累加和
        int res = 0;
        // 当前位上限
        int up = isLimit ? num[i] - '0' : 9;
        // 枚举当前数位填 d
        for (int d = 0; d <= up; d++) {
            res = (res + dfs(i + 1, sum + d, isLimit && (d == up), num, minSum, maxSum, memo)) % MOD;
        }
        if (!isLimit) {
            memo[i][sum] = res;
        }
        return res;
    }


}

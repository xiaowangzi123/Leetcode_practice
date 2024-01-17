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

    private int calc(String s, int minSum, int maxSum) {
        int n = s.length();
        int[][] memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, s.toCharArray(), minSum, maxSum, memo);
    }

    private int dfs(int i, int sum, boolean isLimit, char[] s, int minSum, int maxSum, int[][] memo) {
        if (sum > maxSum) {
            return 0;
        }
        if (i == s.length) {
            return sum >= minSum ? 1 : 0;
        }
        if (!isLimit && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        int up = isLimit ? s[i] - '0' : 9;
        int res = 0;
        // 枚举当前数位填 d
        for (int d = 0; d <= up; d++) {
            res = (res + dfs(i + 1, sum + d, isLimit && (d == up), s, minSum, maxSum, memo)) % MOD;
        }
        if (!isLimit) {
            memo[i][sum] = res;
        }
        return res;
    }



}

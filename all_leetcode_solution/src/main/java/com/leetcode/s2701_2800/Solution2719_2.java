package com.leetcode.s2701_2800;

import java.util.Arrays;

/**
 * 统计整数数目
 */
public class Solution2719_2 {
    public static void main(String[] args) {
        Solution2719_2 solution = new Solution2719_2();

        //11
        System.out.println(solution.count("1", "12", 1, 8));
        //5
        System.out.println(solution.count("1", "5", 1, 5));
        //883045899
        System.out.println(solution.count("4179205230", "7748704426", 8, 46));

    }

    private static final int MOD = 1000000007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        long ans = validCount(num2,max_sum) - validCount(num1,max_sum) + isValid(num1, min_sum, max_sum) + MOD;
        return (int) (ans % MOD);
    }


    /**
     * 获取 num 以内的合法数数量
     */
    private int validCount(String num, int maxSum) {
        int n = num.length();
        // 每一位的记忆化存储上限是 9n 或 max_sum, 因为超过 max_sum 就过滤掉了
        // 直接记忆在 sum 位, 所以 +1
        long[][] memo = new long[n][Math.min(9 * n, maxSum) + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 第一位一定是 limit 的
        return (int) dfs(num, memo, 0, 0, maxSum,true);
    }

    /**
     * 从数字第 i 位开始计算满足条件的 count
     * 这里递归栈为 n 层
     */
    private long dfs(String s, long[][] memo, int i, int sum, int maxSum, boolean isLimit) {
        // 递归求和超出上限, 停止后续计算
        if (sum > maxSum) {
            return 0;
        }

        // 递归求和进行到最后一位, 满足条件返回 1 值
        if (i == s.length()) {
            return sum >= 0 ? 1 : 0;
        }

        // 记忆化存储
        if (!isLimit && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        // 累加和
        long res = 0;

        // 当前位上限
        int up = isLimit ? (s.charAt(i) - '0') : 9;

        // 枚举当前位可填数字
        for (int j = 0; j <= up; j++) {
            // 转移方程：累加 i + 1 位满足条件的 count
            res = (res + dfs(s, memo, i + 1, sum + j, maxSum,isLimit && j == up)) % 1000000007;
        }

        // 记忆化存储累加和
        if (!isLimit) {
            memo[i][sum] = res;
        }

        return res;
    }

    /**
     * 判断单个数是否合法
     */
    private int isValid(String num, int min_sum, int max_sum) {
        long res = 0;
        for (int i = 0; i < num.length(); i++) {
            res += num.charAt(i) - '0';
        }
        return (res >= min_sum && res <= max_sum) ? 1 : 0;
    }

}

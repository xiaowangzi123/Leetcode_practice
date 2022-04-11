package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/4/11
 * @description: TODO
 * 357. 统计各位数字都不同的数字个数
 */
public class Solution0357 {
    public static void main(String[] args) {
        Solution0357 obj = new Solution0357();
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + (dp[i-1] - dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }


}


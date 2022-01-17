package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/1/17
 * @description: 统计元音字母序列的数目
 */
public class Solution1220 {
    public static void main(String[] args) {
        Solution1220 obj = new Solution1220();
        System.out.println(obj.countVowelPermutation(1));
        System.out.println(obj.countVowelPermutation(2));
        System.out.println(obj.countVowelPermutation(3));
        System.out.println(obj.countVowelPermutation(5));
    }

    public int countVowelPermutation(int n) {
        int ans = 0, mod = 1000000007;
        int[][] dp = new int[n + 1][5];
        //序列长度为1时，赋值1
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][1] + dp[i - 1][3];
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = dp[i - 1][2] + dp[i - 1][3];
            for (int j = 0; j < 5; j++) {
                dp[i][j] %= mod;
            }
        }
        for (int j = 0; j < 5; j++) {
            ans += dp[n][j];
            ans %= mod;
        }
        return ans;
    }
}
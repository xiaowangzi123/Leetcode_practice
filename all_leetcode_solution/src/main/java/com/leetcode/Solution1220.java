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
        System.out.println(obj.countVowelPermutation2(1));
        System.out.println(obj.countVowelPermutation(2));
        System.out.println(obj.countVowelPermutation(3));
        System.out.println(obj.countVowelPermutation(5));
        System.out.println(obj.countVowelPermutation(144));
        System.out.println(obj.countVowelPermutation2(144));
    }

    public int countVowelPermutation(int n) {
        int ans = 0, mod = 1000000007;
        long[][] dp = new long[n + 1][5];
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

    public int countVowelPermutation2(int n) {
        int ans = 0, mod = 1000000007;
        long[] dp = new long[5], pre = new long[5];
        //序列长度为1时，赋值1
        Arrays.fill(pre, 1);

        for (int i = 2; i <= n; i++) {
            dp[0] = pre[1] + pre[2] + pre[4];
            dp[1] = pre[0] + pre[2];
            dp[2] = pre[1] + pre[3];
            dp[3] = pre[2];
            dp[4] = pre[2] + pre[3];
            for (int j = 0; j < 5; j++) {
                dp[j] %= mod;
            }
            pre = Arrays.copyOf(dp, 5);
        }
        for (int j = 0; j < 5; j++) {
            ans += pre[j];
            ans %= mod;
        }
        return ans;
    }
}
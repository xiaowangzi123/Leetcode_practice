package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/20
 * @description：
 */
public class Solution0673 {
    public static void main(String[] args) {
        Solution0673 obj = new Solution0673();
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(obj.findNumberOfLIS(arr));

    }

    /**
     * dp[i]表示以nums[i]结尾的最长上升子序列的长度
     * 
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/5
 * @description : 最长定差子序列
 */
public class Solution1218 {
    public static void main(String[] args) {
        Solution1218 obj = new Solution1218();
        int[] arr = {1, 2, 3, 4};
        System.out.println(obj.longestSubsequence(arr, 1));
    }

    public int longestSubsequence(int[] arr, int difference) {
        int count = 0;
        int[] dp = new int[40001];
        for (int num : arr) {
            dp[num + 20000] = dp[num + 20000 - difference] + 1;
            count = Math.max(count, dp[num + 20000]);
        }
        return count;
    }
}
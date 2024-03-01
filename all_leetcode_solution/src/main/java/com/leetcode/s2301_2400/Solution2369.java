package com.leetcode.s2301_2400;

import java.util.Arrays;

/**
 * 检查数组是否存在有效划分
 */
public class Solution2369 {
    public static void main(String[] args) {
        Solution2369 solution = new Solution2369();
        int[] nums = {4, 4, 4, 5, 6};
        int[] nums2 = {1,1,1,2};
        System.out.println(solution.validPartition(nums));
        System.out.println(solution.validPartition(nums2));
    }

    /**
     * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
     * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
     * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。
     * 例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
     */
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        dp[n - 1] = false;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] == nums[i + 1]) {
                dp[i] = dp[i] || dp[i + 2];
            }

            if (i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                dp[i] = dp[i] || dp[i + 3];
            }

            if (i + 2 < n && nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                dp[i] = dp[i] || dp[i + 3];
            }
        }

        return dp[0];
    }


    public boolean validPartition2(int[] nums) {
        int n = nums.length;
        Boolean[] memo = new Boolean[n + 1];
        // 初始化 memo 数组为 null
        Arrays.fill(memo, null);

        return dfs(nums, 0, memo);
    }

    private boolean dfs(int[] nums, int index, Boolean[] memo) {
        if (index == nums.length) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        boolean result = false;

        if (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            result = dfs(nums, index + 2, memo);
        }

        if (!result && index + 2 < nums.length && nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2]) {
            result = dfs(nums, index + 3, memo);
        }

        if (!result && index + 2 < nums.length && nums[index] + 1 == nums[index + 1] && nums[index + 1] + 1 == nums[index + 2]) {
            result = dfs(nums, index + 3, memo);
        }

        memo[index] = result;
        return result;
    }
}

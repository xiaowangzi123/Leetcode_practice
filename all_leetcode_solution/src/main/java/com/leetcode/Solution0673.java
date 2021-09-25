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
        System.out.println(obj.findNumberOfLIS2(arr));

    }

    /**
     * dp[i]表示以nums[i]结尾的最长上升子序列的长度
     * cnt[i]表示以nums[i]结尾的最长上升子序列的个数
     * nums 的最长上升子序列的长度为maxLen
     * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
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

    /**
     * f[i]为nums[i]为结尾的最长上升子序列的长度
     * 由于每个数都能独自一个成为子序列，因此起始必然有 f[i] = 1f[i]=1；
     * 枚举区间[0, i)的所有数 nums[j]：
     * 如果满足nums[j]<nums[i]，说明nums[i]可以接在nums[j]后面形成上升子序列，此时使用f[j]更新f[i]，即有f[i]=f[j]+1。
     * <p>
     * 额外考虑g[i]为以nums[i]结尾的最长上升子序列的个数。
     * 由于每个数都能独自一个成为子序列，因此起始必然有g[i]=1
     * 枚举区间[0,i)的所有数nums[j]，
     * 如果满足 nums[j]<nums[i]，说明nums[i] 可以接在nums[j]后面形成上升子序列，
     * 这时候对f[i]和f[j]+1的大小关系进行分情况讨论：
     * 1.满足f[i]<f[j]+1：说明f[i]会被f[j]+1直接更新，此时同步直接更新g[i]=g[j] 即可；
     * 2.满足f[i]=f[j]+1：说明找到了一个新的符合条件的前驱，此时将值继续累加到结果中，即有g[i]+=g[j]。
     * 同时记录全局最长上升子序列的最大长度 maxmax，最终答案为所有满足f[i]=max的g[i]的累加值。
     */
    public int findNumberOfLIS2(int[] nums) {
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    } else if (f[i] == f[j] + 1) {
                        g[i] += g[j];
                    }
                }
            }
            max = Math.max(max, f[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == max) {
                ans += g[i];
            }
        }
        return ans;
    }
}
package com.leetcode.s2301_2400;

import java.util.Arrays;

/**
 * 检查数组是否存在有效划分
 * TODO
 */
public class Solution2369 {
    public static void main(String[] args) {
        Solution2369 solution = new Solution2369();
        int[] nums = {4, 4, 4, 5, 6};
        int[] nums2 = {1, 1, 1, 2};
        System.out.println(solution.validPartition(nums));
        System.out.println(solution.validPartition(nums2));
    }

    /**
     * 子数组恰由2个相等元素组成，例如，子数组 [2,2] 。
     * 子数组恰由3个相等元素组成，例如，子数组 [4,4,4] 。
     * 子数组恰由3个连续递增元素组成，并且相邻元素之间的差值为 1 。
     * 例如，子数组[3,4,5]，但是子数组[1,3,5]不符合要求。
     *
     * 对于 nums = [4,4,4,5,6] ，第一个子数组可以是 [4,4] 或 [4,4,4] 。去掉这段恢复的整数，例如去掉 [4,4] 后，剩下要解决的问题就是「判断 nums = [4,5,6] 是否存在有效划分」。这是一个和原问题相似的子问题，所以可以用递归解决。
     *
     * 根据上面的讨论，递归参数只需要一个 i ，dfs(i) 表示数组 nums[i:n-1] 是否存在有效划分。假设划分的这段子数组（必须符合题意）的结束下标为 j ，那么以该子数组开头的 nums[i:n-1] 是否存在有效划分，就要看 dfs(j + 1) 的返回值。
     *
     * 考虑「能划分的第一段子数组」的不同结束下标 j jj ，只要其中有一个 d f s ( j + 1 ) dfs(j + 1)dfs(j+1) 为 t r u e truetrue ，则 d f s ( i ) dfs(i)dfs(i) 也为 t r u e truetrue ，否则为 f a l s e falsefalse ，不存在有效划分。
     *
     * 递归边界：d f s ( n ) = t r u e , d f s ( n − 1 ) = f a l s e dfs(n) = true, dfs(n - 1) = falsedfs(n)=true,dfs(n−1)=false 。
     * 递归入口：d f s ( 0 ) dfs(0)dfs(0) ，就是答案。
     * 不难发现，整个递归中有大量重复递归调用（递归入参相同），由于递归函数没有副作用，同样的入参无论计算多少次，算出来的结果都是一样的，因此可以用记忆化搜索来优化。这里用DP数组进行记忆，为了区分已经访问过的位置，我们额外用一个 vis 数组进行标记：
     */
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        dp[n - 1] = false;

        for (int i = n - 2; i >= 0; i--) {
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

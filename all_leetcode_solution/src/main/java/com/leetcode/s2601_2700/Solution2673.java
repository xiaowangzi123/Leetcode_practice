package com.leetcode.s2601_2700;

/**
 * 使二叉树所有路径值相等的最小代价
 */
public class Solution2673 {
    public static void main(String[] args) {
        Solution2673 solution = new Solution2673();
        int[] nums = new int[]{1, 5, 2, 2, 3, 3, 1};
        int[] nums2 = new int[]{5, 3, 3};
        System.out.println(solution.minIncrements(7, nums));
        System.out.println(solution.minIncrements(3, nums2));
    }

    /**
     *
     */
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        // 从最后一个非叶节点开始算
        for (int i = n / 2; i > 0; i--) {
            // 两个子节点变成一样的
            ans += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            // 累加路径和
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return ans;

    }
}

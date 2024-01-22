package com.leetcode.s0401_0500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 分割数组的最大值
 */
public class Solution0410 {
    public static void main(String[] args) {
        Solution0410 solution = new Solution0410();
        int[] nums = {7,2,5,10,8};
        System.out.println(solution.splitArray(nums,2));
    }

    /**
     * TODO
     * 动态规划
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}

package com.leetcode.s2801_2900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使数组和小于等于X的最小时间
 * 1 <= nums1.length <= 103
 * 1 <= nums1[i] <= 103
 * 0 <= nums2[i] <= 103
 * nums1.length == nums2.length
 * 0 <= x <= 106
 */
public class Solution2809 {
    public static void main(String[] args) {
        Solution2809 solution = new Solution2809();
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(solution.minimumTime(nums1, nums2, 4));
    }

    /**
     * 动态规划求解
     * TODO
     */
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[] dp = new int[n + 1];
        List<List<Integer>> nums = new ArrayList<>();
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i), b = nums2.get(i);
            nums.add(Arrays.asList(b, a));
            s1 += a;
            s2 += b;
        }
        nums.sort((o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));

        for (int j = 1; j <= n; ++j) {
            int b = nums.get(j - 1).get(0), a = nums.get(j - 1).get(1);
            for (int i = j; i > 0; --i) {
                dp[i] = Math.max(dp[i], dp[i - 1] + i * b + a);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (s2 * i + s1 - dp[i] <= x) {
                return i;
            }
        }
        return -1;

    }
}

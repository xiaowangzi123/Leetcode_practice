package com.leetcode.s1601_1700;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 石子游戏 VI
 */
public class Solution1696 {
    public static void main(String[] args) {

        Solution1696 solution = new Solution1696();

        System.out.println(solution.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(solution.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
        System.out.println(solution.maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 3));
    }

    /**
     * TODO
     */
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);

        for (int i = 1; i < n; i++) {
            while (i - dq.peek() > k) {
                dq.poll();
            }
            dp[i] = nums[i] + dp[dq.peekFirst()];

            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) {
                dq.pollLast();
            }
            dq.offer(i);
        }

        return dp[n - 1];

    }
}

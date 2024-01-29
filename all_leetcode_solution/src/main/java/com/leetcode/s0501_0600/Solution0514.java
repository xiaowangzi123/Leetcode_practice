package com.leetcode.s0501_0600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自由之路
 */
public class Solution0514 {
    public static void main(String[] args) {
        Solution0514 solution = new Solution0514();
        System.out.println(solution.findRotateSteps("godding", "gd"));
        System.out.println(solution.findRotateSteps("godding", "godding"));
    }

    int[][] dp;
    List<Integer>[] pos;

    /**
     * TODO
     * 动态规划
     */
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();
        dp = new int[keyLen][ringLen];
        pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < ringLen; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }

        for (int i = 0; i < keyLen; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j : pos[key.charAt(0) - 'a']) {
            dp[0][j] = Math.min(j, ringLen - j) + 1;
        }

        for (int i = 1; i < keyLen; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    int d = Math.min(Math.abs(k - j), ringLen - Math.abs(k - j)) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + d);
                }
            }
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < ringLen; i++) {
            minSteps = Math.min(minSteps, dp[keyLen - 1][i]);
        }

        return minSteps;
    }
}

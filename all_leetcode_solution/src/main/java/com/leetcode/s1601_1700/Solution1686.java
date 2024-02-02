package com.leetcode.s1601_1700;

import java.util.Arrays;

/**
 * 石子游戏VI
 */
public class Solution1686 {
    public static void main(String[] args) {

        Solution1686 solution = new Solution1686();

        System.out.println(solution.stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
        System.out.println(solution.stoneGameVI(new int[]{1, 2}, new int[]{3, 1}));
        System.out.println(solution.stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7}));
    }

    /**
     * TODO
     *
     */
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] ps = new int[n][2];

        for (int i = 0; i < n; i++) {
            ps[i][0] = aliceValues[i];
            ps[i][1] = bobValues[i];
        }

        Arrays.sort(ps, (p1, p2) -> Integer.compare(p2[0] + p2[1], p1[0] + p1[1]));

        int ascore = 0, bscore = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ascore += ps[i][0];
            } else {
                bscore += ps[i][1];
            }
        }

        return ascore == bscore ? 0 : (ascore < bscore ? -1 : 1);

    }
}

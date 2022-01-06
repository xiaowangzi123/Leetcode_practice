package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/7
 * @description: 你可以获得的最大硬币数目
 */
public class Solution1561 {
    public static void main(String[] args) {
        Solution1561 obj = new Solution1561();
        System.out.println(obj.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
    }

    public int maxCoins(int[] piles) {
        int max = 0, len = piles.length;
        Arrays.sort(piles);
        for (int i = len / 3; i < len * 2 / 3; i++) {
            max += piles[i];
        }
        return max;
    }
}
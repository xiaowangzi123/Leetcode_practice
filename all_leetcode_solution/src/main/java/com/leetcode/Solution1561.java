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
        System.out.println(obj.maxCoins(new int[]{2, 4, 5}));
        System.out.println(obj.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(obj.maxCoins2(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
        System.out.println(obj.maxCoins2(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4, 11, 10, 12}));
    }

    /**
     * 对数组排序，三个一组的数组中，每次取第二大的数
     */
    public int maxCoins(int[] piles) {
        int max = 0, len = piles.length;
        Arrays.sort(piles);
        for (int i = len - 2; i >= len / 3; i -= 2) {
            max += piles[i];
        }
        return max;
    }

    public int maxCoins2(int[] piles) {
        int max = 0, len = piles.length;
        Arrays.sort(piles);
        int count = len / 3, index = len - 2;
        while (count > 0) {
            max += piles[index];
            index -= 2;
            count--;
        }
        return max;
    }
}
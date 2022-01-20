package com.leetcode;

import java.util.spi.CurrencyNameProvider;

/**
 * @author: wyq
 * @create time: 2022/1/20
 * @description: 石子游戏 IX
 */
public class Solution2029 {
    public static void main(String[] args) {
        Solution2029 obj = new Solution2029();
        System.out.println(obj.stoneGameIX(new int[]{2, 1}));
        System.out.println(obj.stoneGameIX(new int[]{2}));
        System.out.println(obj.stoneGameIX(new int[]{5,1,2,4,3}));
    }

    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int i : stones) {
            cnt[i % 3]++;
        }
        if (cnt[0] % 2 == 0) {
            return cnt[1] > 0 && cnt[2] > 0;
        }
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }

}
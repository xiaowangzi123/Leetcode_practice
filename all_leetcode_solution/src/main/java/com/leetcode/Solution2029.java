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
        System.out.println(obj.stoneGameIX(new int[]{1, 2, 1}));
        System.out.println(obj.stoneGameIX(new int[]{2}));
        System.out.println(obj.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
    }

    /**
     * 石头价值除以3的余数分别为0,1,2，可以直接用0,1,2代表它们的价值，对应的石子数量分别为cun[0]、cun[1]、cun[2]
     *
     * 1.如果cun[0]为偶数，B在A选择1或2后选择0，A也可以选择0，相当于都没有选择，可以去掉
     * 最终序列11 21 21 21……或者22 12 12 12……，
     * 1.1这种情况下，序列只有1，A输；序列只有2，A也输；
     * 1.2cnt[1]>0&&cnt[2]>0时，1和2一样多，A先选1，或2，A都赢；1比2多，A先选2，A赢；1比2少，A先选1，A赢
     * 2.cun[0]为奇数，相当于交互先后手，序列为10 12 12 12……或者20 21 21 21……
     * A能赢的条件是1和2的数量的差绝对值大于2
     */
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
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/12
 * @description : 拥有最多糖果的孩子
 */
public class Solution1431 {
    public static void main(String[] args) {
        Solution1431 obj = new Solution1431();
        int[] candies = {4, 2, 1, 1, 2};
        int extraCandies = 1;
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
        System.out.println(obj.kidsWithCandies2(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int a : candies) {
            max = Math.max(a, max);
        }

        List<Boolean> res = new ArrayList<>();
        for (int a : candies) {
            res.add(a + extraCandies >= max);
        }
        return res;
    }
}
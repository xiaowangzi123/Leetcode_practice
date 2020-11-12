package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/12
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[] candies = {4, 2, 1, 1, 2};
        int extraCandies = 1;
        Solution obj = new Solution();
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
            } else res.add(false);
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
            if (a + extraCandies >= max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
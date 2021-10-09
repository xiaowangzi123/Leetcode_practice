package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description :
 */
public class Solution0575 {
    public static void main(String[] args) {
        Solution0575 obj = new Solution0575();
//        int[] candies = {1, 1, 2, 2, 3, 3};
        int[] candies = {1, 1, 2, 3};

        System.out.println(obj.distributeCandies(candies));
        System.out.println(obj.distributeCandies2(candies));
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> kinds = new HashSet<>();
        for (int i : candyType) {
            kinds.add(i);
        }
        return Math.min(kinds.size(), candyType.length / 2);
    }

    public int distributeCandies2(int[] candyType) {
        Arrays.sort(candyType);
        int n = candyType.length, count = 1;
        for (int i = 1; i < n && count < n / 2; i++) {
            if (candyType[i] > candyType[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
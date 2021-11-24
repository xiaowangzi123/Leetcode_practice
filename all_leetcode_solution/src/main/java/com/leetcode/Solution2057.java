package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 值相等的最小索引
 */
public class Solution2057 {
    public static void main(String[] args) {
        Solution2057 obj = new Solution2057();
        System.out.println(obj.smallestEqual(new int[]{4, 3, 2, 1}));
        System.out.println(obj.smallestEqual(new int[]{7, 8, 3, 5, 2, 6, 3, 1, 1, 4, 5, 4, 8, 7, 2, 0, 9, 9, 0, 5, 7, 1, 6}));
    }

    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
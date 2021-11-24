package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 学生分数的最小差值
 */
public class Solution1984 {
    public static void main(String[] args) {
        Solution1984 obj = new Solution1984();
        System.out.println(obj.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, min = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
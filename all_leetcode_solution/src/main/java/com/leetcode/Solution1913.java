package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/23
 * @description : 两个数对之间的最大乘积差
 */
public class Solution1913 {
    public static void main(String[] args) {
        Solution1913 obj = new Solution1913();
        System.out.println(obj.maxProductDifference(new int[]{5, 6, 2, 7, 4}));
    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
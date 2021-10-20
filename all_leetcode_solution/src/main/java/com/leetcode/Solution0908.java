package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 最小差值 I
 */
public class Solution0908 {
    public static void main(String[] args) {
        Solution0908 obj = new Solution0908();
        int[] arr = {1, 3, 6};
        System.out.println(obj.smallestRangeI(arr, 3));
        System.out.println(obj.smallestRangeI2(arr, 3));
    }

    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n - 1] - nums[0]) > k * 2 ? nums[n - 1] - nums[0] - k * 2 : 0;
    }

    public int smallestRangeI2(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
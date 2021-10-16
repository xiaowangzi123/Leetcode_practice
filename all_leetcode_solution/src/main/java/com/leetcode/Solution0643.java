package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description :子数组最大平均数 I
 */
public class Solution0643 {
    public static void main(String[] args) {
        Solution0643 obj = new Solution0643();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(obj.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }
}
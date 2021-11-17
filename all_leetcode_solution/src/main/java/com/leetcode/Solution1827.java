package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/17
 * @description : 最少操作使数组递增
 */
public class Solution1827 {
    public static void main(String[] args) {
        Solution1827 obj = new Solution1827();
//        int[] nums = {1, 1, 1};
//        int[] nums = {1, 5, 2, 4, 1};
//        int[] nums = {1, 5, 6};
        int[] nums = {1, 5, 6};
        System.out.println(obj.minOperations(nums));
    }

    public int minOperations(int[] nums) {
        int count = 0, temp = 0, index = 0;
        int sum = 0, n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                temp = nums[i - 1];
                index = i - 1;
                for (int j = i - 1; j < nums.length; j++) {
                    sum += nums[j];
                }
                break;
            }
        }
        if (sum > 0) {
            count = (n - index) * (temp * 2 + n - index - 1) / 2 - sum;
        }

        return count;
    }
}
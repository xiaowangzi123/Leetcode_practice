package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/17
 * @description : 最少操作使数组递增
 */
public class Solution1827 {
    public static void main(String[] args) {
        Solution1827 obj = new Solution1827();
        int[] nums = {1, 1, 1};
        System.out.println(obj.minOperations(nums));
    }

    public int minOperations(int[] nums) {
        int count = 0, temp = 0, index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                temp = nums[i - 1];
                index = i - 1;
            }
            count += (temp + index - i - nums[i]);
        }

        return count;
    }
}
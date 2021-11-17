package com.leetcode;

import java.util.Arrays;

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
        int[] nums = {4881, 2593, 6819, 9256, 4135};
//        int[] nums = {7, 3, 10, 20, 5};
        System.out.println(obj.minOperations2(nums));
    }

    /**
     * TODO
     * 思路待改进
     */
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

    public int minOperations2(int[] nums) {
        int n = nums.length, ans = 0;
        int[] arr = nums.clone();
        for (int i = 1; i < n; i++) {
            if (nums[i] <= arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
            ans += arr[i] - nums[i];
        }
        return ans;
    }

    public int minOperations3(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 1; i < n; i++) {
            int temp = nums[i - 1] - nums[i];
            if (temp >= 0) {
                ans += temp + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }
}
package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description : K 次取反后最大化的数组和
 */
public class Solution1005 {
    public static void main(String[] args) {
        Solution1005 obj = new Solution1005();
//        int[] nums = {4, 2, 3};
//        System.out.println(obj.largestSumAfterKNegations(nums, 1));
        int[] nums = {2, -3, -1, 5, -4};
        System.out.println(obj.largestSumAfterKNegations2(nums, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        int min = 0;
        while (k > 0) {
            nums[min] = -nums[min];
            if (min + 1 < nums.length && nums[min + 1] < nums[min]) {
                min++;
            }
            k--;
        }
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k >0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
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
        int[] nums = {4, 2, 3};
        System.out.println(obj.largestSumAfterKNegations(nums, 1));
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
        /*for (int num : nums) {
            sum += num;
        }*/
        return Arrays.stream(nums).sum();
    }
}
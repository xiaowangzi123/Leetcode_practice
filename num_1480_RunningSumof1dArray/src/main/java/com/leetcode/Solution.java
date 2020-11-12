package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/12
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 2, 6};
        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.runningSum(arr)));

        int[] arr2 = {1, 4, 7, 2, 6};
        System.out.println(Arrays.toString(obj.runningSum2(arr2)));
    }

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public int[] runningSum2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sum + nums[i];
            sum = nums[i];
        }
        return nums;
    }
}
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
    }

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
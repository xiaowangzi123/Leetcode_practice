package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/12
 * @description： 一维数组的动态和
 */
public class Solution1480 {
    public static void main(String[] args) {
        Solution1480 obj = new Solution1480();
        int[] arr = {1, 4, 7, 2, 6};
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
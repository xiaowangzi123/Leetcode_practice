package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 数组中两元素的最大乘积
 */
public class Solution1464 {
    public static void main(String[] args) {
        Solution1464 obj = new Solution1464();
//        int[] arr = {3, 5, 5, 2};
        int[] arr = {10, 5, 5, 9};
        System.out.println(obj.maxProduct(arr));
        System.out.println(obj.maxProduct2(arr));
    }

    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int a : nums) {
            if (a >= max1) {
                max2 = max1;
                max1 = a;
            } else if (a >= max2) {
                max2 = a;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
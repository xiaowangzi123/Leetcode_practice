package com.leetcode.s0801_0900;

/**
 * 单调数列
 */
public class Solution0896 {
    public static void main(String[] args) {
        Solution0896 obj = new Solution0896();
//        int[] arr = {1, 2, 2, 3};
        int[] arr = {1, 2, 4, 3};
        System.out.println(obj.isMonotonic(arr));

    }

    public boolean isMonotonic(int[] nums) {
        boolean flag = true, flag2 = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                flag = false;
                break;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag2 = false;
                break;
            }
        }

        return flag || flag2;
    }
}
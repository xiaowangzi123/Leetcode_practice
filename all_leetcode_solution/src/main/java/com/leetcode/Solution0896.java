package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description :
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
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag2 = false;
            }
        }

        return flag || flag2;
    }
}
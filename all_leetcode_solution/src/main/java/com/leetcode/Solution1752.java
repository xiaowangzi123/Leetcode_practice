package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/14
 * @description : 检查数组是否经排序和轮转得到
 */
public class Solution1752 {
    public static void main(String[] args) {
        Solution1752 obj = new Solution1752();
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {1,1,1};
        int[] nums = {3, 4, 3};
        System.out.println(obj.check2(nums));
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int index = 0;
        while (index < n) {

        }
        return true;
    }

    /**
     * 有
     */
    public boolean check2(int[] nums) {
        int n = nums.length;
        boolean flag = nums[0] >= nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
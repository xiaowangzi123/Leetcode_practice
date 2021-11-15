package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/15
 * @description : 最大升序子数组和
 */
public class Solution1800 {
    public static void main(String[] args) {
        Solution1800 obj = new Solution1800();
        int[] arr = {12, 17, 15, 13, 10, 11, 12};
        System.out.println(obj.maxAscendingSum(arr));
    }

    public int maxAscendingSum(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        int i = 0, n = nums.length;
        while (i < n) {
            while (i < n && nums[i] < nums[i + 1]) {
                sum += nums[i];
                i++;
            }
            max = Math.max(sum, max);
            i++;
        }

        return max;
    }
}
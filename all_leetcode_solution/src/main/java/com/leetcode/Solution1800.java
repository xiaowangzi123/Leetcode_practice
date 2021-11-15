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
//        int[] arr = {12};
        System.out.println(obj.maxAscendingSum(arr));
        System.out.println(obj.maxAscendingSum2(arr));
    }

    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], max = nums[0];
        int i = 1, n = nums.length;
        while (i < n) {
            while (i < n && nums[i - 1] < nums[i]) {
                sum += nums[i];
                i++;
            }
            max = Math.max(sum, max);
            if (i < n) {
                sum = nums[i];
            }
            i++;
        }

        return max;
    }

    public int maxAscendingSum2(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
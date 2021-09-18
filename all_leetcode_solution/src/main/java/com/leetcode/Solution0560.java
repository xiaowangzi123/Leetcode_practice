package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
 */
public class Solution0560 {
    public static void main(String[] args) {
        Solution0560 obj = new Solution0560();
        int[] arr = {1, 2, 3, 4};
        System.out.println(obj.subarraySum(arr, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
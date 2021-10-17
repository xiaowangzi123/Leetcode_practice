package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0724 {
    public static void main(String[] args) {
        Solution0724 obj = new Solution0724();
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(obj.pivotIndex(arr));
        System.out.println(obj.pivotIndex2(arr));
    }

    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += nums[j];
            }
            for (int k = i + 1; k < nums.length; k++) {
                sum2 += nums[k];
            }
            if (sum1 == sum2) {
                return i;
            }
        }
        return -1;
    }


    public int pivotIndex2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum1 * 2 + nums[i] == sum) {
                return i;
            }
            sum1 += nums[i];
        }

        return -1;
    }
}
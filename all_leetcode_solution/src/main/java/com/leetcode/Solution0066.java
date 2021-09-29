package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/9/29
 * @description :
 */
public class Solution0066 {
    public static void main(String[] args) {
        Solution0066 obj = new Solution0066();
        int[] nums = {1, 2, 9};
        System.out.println(Arrays.toString(obj.plusOne(nums)));

        int[] nums2 = {9, 9, 9};
        System.out.println(Arrays.toString(obj.plusOne(nums2)));
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
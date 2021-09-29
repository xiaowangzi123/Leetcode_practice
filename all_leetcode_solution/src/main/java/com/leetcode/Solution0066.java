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
        System.out.println(Arrays.toString(obj.plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(obj.plusOne2(new int[]{1, 2, 9})));

        int[] nums2 = {9, 9, 9};
        System.out.println(Arrays.toString(obj.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(obj.plusOne2(new int[]{9, 9, 9})));
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
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int m = digits.length - 1, n = 0, k = 0;
        while (m >= 0 || n >= 0) {
            int i = m >= 0 ? digits[m] : 0;
            int j = n >= 0 ? 1 : 0;
            digits[m] = (i + j + k) % 10;
            k = (i + j + k) / 10;
            if (k == 0) {
                return digits;
            }
            m--;
            n--;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
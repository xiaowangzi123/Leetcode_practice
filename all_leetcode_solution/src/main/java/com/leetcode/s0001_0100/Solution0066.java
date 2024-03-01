package com.leetcode.s0001_0100;

import java.util.Arrays;

/**
 * 加一
 */
public class Solution0066 {
    public static void main(String[] args) {
        Solution0066 obj = new Solution0066();
        int[] nums = {1, 2, 9};
        System.out.println(Arrays.toString(obj.plusOne(nums)));
        System.out.println(Arrays.toString(obj.plusOne2(nums)));
        System.out.println(Arrays.toString(obj.plusOne3(nums)));

        int[] nums2 = {9, 9, 9};
        System.out.println(Arrays.toString(obj.plusOne(nums2)));
        System.out.println(Arrays.toString(obj.plusOne2(nums2)));
        System.out.println(Arrays.toString(obj.plusOne3(nums2)));
    }

    /**
     * 从低位每次加1，如果除以10，余数是0，表明有进位；余数非0，表明可以结束了
     */
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

    public int[] plusOne3(int[] digits) {
        int n = digits.length, temp = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                digits[i]++;
            } else {
                digits[i] += temp;
            }
            temp = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (temp == 1) {
            digits = new int[n + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
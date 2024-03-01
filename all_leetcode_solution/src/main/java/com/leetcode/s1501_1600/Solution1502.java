package com.leetcode.s1501_1600;

import java.util.Arrays;

/**
 * 判断能否形成等差数列
 */
public class Solution1502 {
    public static void main(String[] args) {
        Solution1502 obj = new Solution1502();
//        int[] arr = {3, 1, 5};
        int[] arr = {-509, -19, -439, -264, -404, -369, -299, -89, -229, -54, -194, 16, -544, -159, -124, -474, -334};
        System.out.println(obj.canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int temp = Math.abs(arr[0] - arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) != temp) {
                return false;
            }
        }
        return true;
    }
}
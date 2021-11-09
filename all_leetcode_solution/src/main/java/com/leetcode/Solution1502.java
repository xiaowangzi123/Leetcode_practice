package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 判断能否形成等差数列
 */
public class Solution1502 {
    public static void main(String[] args) {
        Solution1502 obj = new Solution1502();
        int[] arr = {3, 1, 5};
        System.out.println(obj.canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length, temp = Math.abs(arr[0] - arr[1]);
        Arrays.sort(arr);
        for (int i = 2; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) != temp) {
                return false;
            }
        }
        return true;
    }
}
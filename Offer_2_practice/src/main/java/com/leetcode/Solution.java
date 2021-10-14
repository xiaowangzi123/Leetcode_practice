package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/17
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Solution obj = new Solution();
        System.out.println(obj.sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j + i <= arr.length; j += 2) {
                for (int k = i; k < i + j; k++) {
                    res += arr[k];
                }
            }
        }
        return res;
    }
}
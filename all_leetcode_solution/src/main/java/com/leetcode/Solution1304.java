package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 和为零的N个唯一整数
 */
public class Solution1304 {
    public static void main(String[] args) {
        Solution1304 obj = new Solution1304();
        System.out.println(Arrays.toString(obj.sumZero(5)));
    }

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i;
            sum += i;
        }
        ans[n - 1] = -sum;
        return ans;
    }
}
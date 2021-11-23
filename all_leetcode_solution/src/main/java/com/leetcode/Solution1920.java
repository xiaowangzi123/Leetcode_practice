package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 基于排列构建数组
 */
public class Solution1920 {
    public static void main(String[] args) {
        Solution1920 obj = new Solution1920();
        System.out.println(Arrays.toString(obj.buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 数组串联
 */
public class Solution1929 {
    public static void main(String[] args) {
        Solution1929 obj = new Solution1929();
        System.out.println(Arrays.toString(obj.getConcatenation(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(obj.getConcatenation2(new int[]{1, 2, 3})));
    }

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            ans[i] = nums[i % n];
        }
        return ans;
    }

    public int[] getConcatenation2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i + n] = nums[i];
        }
        return ans;
    }
}
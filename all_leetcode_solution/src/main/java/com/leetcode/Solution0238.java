package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
 */
public class Solution0238 {
    public static void main(String[] args) {
        Solution0238 obj = new Solution0238();
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(obj.productExceptSelf(arr)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, left = 1, right = 1;
        int[] res = new int[n];
        //第i个元素左边所有数的乘积，第0个元素左边默认为1
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }
        //right第i个元素右边的所有数乘积
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
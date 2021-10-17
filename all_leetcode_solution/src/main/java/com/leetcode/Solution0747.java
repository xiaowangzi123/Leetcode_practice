package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description : 至少是其他数字两倍的最大数
 */
public class Solution0747 {
    public static void main(String[] args) {
        Solution0747 obj = new Solution0747();
//        int[] nums = {3, 6, 1, 0};
        int[] nums = {1, 2, 3, 4};
        System.out.println(obj.dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {
        int ans = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                ans = i;
            }
        }
        for (int num : nums) {
            if (num != max && num * 2 > max) {
                return -1;
            }
        }
        return ans;
    }
}
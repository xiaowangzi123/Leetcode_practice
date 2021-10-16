package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description :重塑矩阵
 */
public class Solution0566 {
    public static void main(String[] args) {
        Solution0566 obj = new Solution0566();
        int[] arr = {1, 4, 3, 2};
        System.out.println(obj.arrayPairSum(arr));
    }

    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
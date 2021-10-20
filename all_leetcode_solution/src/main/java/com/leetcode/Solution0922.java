package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 按奇偶排序数组 II
 */
public class Solution0922 {
    public static void main(String[] args) {
        Solution0922 obj = new Solution0922();
        int[] arr = {4, 2, 5, 7};
        System.out.println(Arrays.toString(obj.sortArrayByParityII(arr)));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length, index = 0, index1 = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ans[index] = nums[i];
                index += 2;
            }
            if (nums[i] % 2 == 1) {
                ans[index1] = nums[i];
                index1 += 2;
            }
        }
        return ans;
    }
}
package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description : 有序数组的平方
 */
public class Solution0977 {
    public static void main(String[] args) {
        Solution0977 obj = new Solution0977();
        int[] arr = {-4, -1, 0, 3, 1};
        System.out.println(Arrays.toString(obj.sortedSquares(arr)));
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

}
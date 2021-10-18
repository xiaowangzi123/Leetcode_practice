package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description :
 */
public class Solution0905 {
    public static void main(String[] args) {
        Solution0905 obj = new Solution0905();
        int[] arr = {3, 1, 2, 4};
        System.out.println(Arrays.toString(obj.sortArrayByParity(arr)));
    }

    public int[] sortArrayByParity(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                start++;
            }
            if (nums[end] % 2 != 0) {
                end--;
            }
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
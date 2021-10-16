package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :最长连续递增序列
 */
public class Solution0674 {
    public static void main(String[] args) {
        Solution0674 obj = new Solution0674();
//        int[] arr = {1, 3, 5, 4, 7};
        int[] arr = {2, 2, 2, 2, 2};
        System.out.println(obj.findLengthOfLCIS(arr));
    }

    public int findLengthOfLCIS(int[] nums) {
        int count = 0, start = 0, index = 0, n = nums.length;
        while (index < n) {
            if (index > 0 && nums[index - 1] < nums[index]) {
                index++;
                count = Math.max(count, index - start);
            } else {
                index++;
                start = index;
            }
        }
        return count + 1;
    }
}
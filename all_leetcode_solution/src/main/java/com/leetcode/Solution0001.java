package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description ： 1. 两数之和
 */
public class Solution0001 {
    public static void main(String[] args) {
        Solution0001 obj = new Solution0001();
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }

    /**
     * 暴力遍历数组
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


}
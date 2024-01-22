package com.leetcode.s0401_0500;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description :最小操作次数使数组元素相等
 */
public class Solution0453 {
    public static void main(String[] args) {
        Solution0453 obj = new Solution0453();
        int[] arr = {1, 2, 3};
        System.out.println(obj.minMoves(arr));
        System.out.println(obj.minMoves2(arr));
    }

    /**
     * n-1个数同时加一，就好比每次有一个数自身减一，所以反向考虑做减法，
     * 最小操作就是数组最后的数只能是最小值。
     * 每个元素减去最小值求其和就是答案
     */
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum - nums[0] * nums.length;
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            count += nums[i] - nums[0];
        }
        return count;
    }
}
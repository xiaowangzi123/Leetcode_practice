package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description：
 */
public class Solution0453 {
    public static void main(String[] args) {
        Solution0453 obj = new Solution0453();
        int[] arr = {1, 2, 3};
        System.out.println(obj.minMoves(arr));
    }

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum-nums[0]*nums.length;
    }
}
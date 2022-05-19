package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description： 462. 最少移动次数使数组元素相等 II
 */
public class Solution0462 {
    public static void main(String[] args) {
        Solution0462 obj = new Solution0462();
        System.out.println(obj.minMoves2(new int[]{1, 10, 2, 9}));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, i = 0, j = nums.length - 1;
        while (i < j) {
            ans += nums[j--] - nums[i++];
        }
        return ans;
    }
}
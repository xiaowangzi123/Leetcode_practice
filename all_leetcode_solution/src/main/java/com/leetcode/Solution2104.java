package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/3/5
 * @description: 子数组范围和
 */
public class Solution2104 {
    public static void main(String[] args) {
        Solution2104 obj = new Solution2104();
        System.out.println(obj.subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(obj.subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(obj.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    /**
     * 子数组是数组中一个连续 非空 的元素序列。
     */
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/17
 * @description : 到目标元素的最小距离
 */
public class Solution1848 {
    public static void main(String[] args) {
        Solution1848 obj = new Solution1848();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(obj.getMinDistance(nums, 5, 3));
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min,Math.abs(i-start));
            }
        }
        return min;
    }

}
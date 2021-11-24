package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 增量元素之间的最大差值
 */
public class Solution2016 {
    public static void main(String[] args) {
        Solution2016 obj = new Solution2016();
        System.out.println(obj.maximumDifference(new int[]{7, 1, 5, 4}));
        System.out.println(obj.maximumDifference(new int[]{9, 4, 3, 2}));
        System.out.println(obj.maximumDifference(new int[]{1, 5, 2, 10}));
    }

    public int maximumDifference(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && max < nums[j] - nums[i]) {
                    max = nums[j] - nums[i];
                }
            }
        }
        return max;
    }
}
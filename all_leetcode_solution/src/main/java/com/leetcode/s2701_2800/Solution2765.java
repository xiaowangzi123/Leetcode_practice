package com.leetcode.s2701_2800;

/**
 * 最长交替子数组
 */
public class Solution2765 {
    public static void main(String[] args) {
        Solution2765 solution = new Solution2765();
        int[] nums = {2, 3, 4, 3, 4};
        int[] nums2 = {4, 5, 6};
        System.out.println(solution.alternatingSubarray(nums));
        System.out.println(solution.alternatingSubarray(nums2));
    }

    public int alternatingSubarray(int[] nums) {
        int max = -1;
        int count = 1;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i, k = j + 1; k < len; j++, k++) {
                if (nums[k] - nums[j] == Math.pow(-1, count + 1)) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
            count = 1;
        }

        return max == 1 ? -1 : max;
    }
}

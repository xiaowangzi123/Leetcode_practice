package com.leetcode.s1801_1900;

/**
 * 数组元素积的符号
 */
public class Solution1822 {
    public static void main(String[] args) {
        Solution1822 obj = new Solution1822();
        int[] nums = {};
        System.out.println(obj.arraySign(nums));
    }

    public int arraySign(int[] nums) {
        int ans = 1;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            }
            if (i < 0) {
                ans *= (-1);
            }
        }
        return ans;
    }
}
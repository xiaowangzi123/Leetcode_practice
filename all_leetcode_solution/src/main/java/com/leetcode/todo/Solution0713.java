package com.leetcode.todo;

/**
 * @author :wyq
 * @date ：Created in 2022/5/5
 * @description : TODO
 * 713. 乘积小于 K 的子数组
 */
public class Solution0713 {
    public static void main(String[] args) {
        Solution0713 obj = new Solution0713();
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
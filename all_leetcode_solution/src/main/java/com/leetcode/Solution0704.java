package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description :
 */
public class Solution0704 {
    public static void main(String[] args) {
        Solution0704 obj = new Solution0704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(obj.search(nums, 9));
        System.out.println(obj.search(nums, 4));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
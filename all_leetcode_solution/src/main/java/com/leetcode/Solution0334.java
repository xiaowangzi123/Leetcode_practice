package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
 */
public class Solution0334 {
    public static void main(String[] args) {
        Solution0334 obj = new Solution0334();
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {2, 1, 5, 0, 4, 6};

        System.out.println(obj.increasingTriplet(arr2));
        System.out.println(obj.increasingTriplet(arr3));
        System.out.println((int) Math.pow(2, 31) == Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);
    }

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else if (nums[i] > mid) {
                return true;
            }
        }
        return false;
    }
}
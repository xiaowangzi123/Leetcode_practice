package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0035 {
    public static void main(String[] args) {
        Solution0035 obj = new Solution0035();
        int[] arr = {1, 3, 5, 6};
        int target = 5;
        System.out.println(obj.searchInsert(arr, target));

        int target2 = 0;
        System.out.println(obj.searchInsert(arr, target2));

        int target3 = 7;
        System.out.println(obj.searchInsert(arr, target3));

    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = nums.length - 1; i >= 0 && i < nums.length; i--) {
            if (nums[i] < target) {
                return i + 1;
            }
        }
        return 0;
    }


}
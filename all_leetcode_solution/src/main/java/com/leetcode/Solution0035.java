package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description： 搜索插入位置
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

        System.out.println("-------------");
        System.out.println(obj.searchInsert2(arr, target));
        System.out.println(obj.searchInsert2(arr, target2));
        System.out.println(obj.searchInsert2(arr, target3));

    }

    public int searchInsert(int[] nums, int target) {
        //先找相等的
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        //从后往前遍历
        for (int i = nums.length - 1; i >= 0 && i < nums.length; i--) {
            if (nums[i] < target) {
                return i + 1;
            }
        }
        return 0;
    }


    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }


}
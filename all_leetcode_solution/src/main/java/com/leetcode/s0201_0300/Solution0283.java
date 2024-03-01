package com.leetcode.s0201_0300;

import java.util.Arrays;

/**
 * 移动零
 */
public class Solution0283 {
    public static void main(String[] args) {
        Solution0283 obj = new Solution0283();
        int[] arr = {0, 1, 0, 3, 12};
        obj.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 如果数组没有0，那么快慢指针始终指向同一个位置，每个位置自己和自己交换；
     * 如果数组有0，快指针先走一步，此时慢指针对应的就是0，所以要交换。
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
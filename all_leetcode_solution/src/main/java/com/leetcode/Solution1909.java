package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/22
 * @description : 删除一个元素使数组严格递增
 */
public class Solution1909 {
    public static void main(String[] args) {
        Solution1909 obj = new Solution1909();
        System.out.println(obj.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(obj.canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(obj.canBeIncreasing(new int[]{1, 1, 1}));
    }

    public boolean canBeIncreasing(int[] nums) {
        int count = 0, n = nums.length;
        int min = nums[0], max = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= min) {
                count++;
                if (count > 1) {
                    break;
                }
            } else {
                min = nums[i];
            }
        }
        if (count <= 1) {
            return true;
        }
        count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= max) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else {
                max = nums[i];
            }
        }
        return true;
    }
}
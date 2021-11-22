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
        System.out.println(obj.canBeIncreasing2(new int[]{1, 2, 10, 5, 7}));
        System.out.println(obj.canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(obj.canBeIncreasing2(new int[]{2, 3, 1, 2}));
        System.out.println(obj.canBeIncreasing(new int[]{1, 1, 1}));
        System.out.println(obj.canBeIncreasing2(new int[]{1, 1, 1}));
    }

    public boolean canBeIncreasing(int[] nums) {
        int count = 0, n = nums.length;
        int max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= max) {
                count++;
                if (count > 1) {
                    break;
                }
            } else {
                max = nums[i];
            }
        }
        if (count <= 1) {
            return true;
        }
        count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= min) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else {
                min = nums[i];
            }
        }
        return true;
    }

    public boolean canBeIncreasing2(int[] nums) {
        boolean flag = true;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                if (flag) {
                    if (i == 1 || nums[i] > nums[i - 2]) {
                        flag = false;
                    } else if (i == n - 1 || nums[i + 1] > nums[i - 1]) {
                        flag = false;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
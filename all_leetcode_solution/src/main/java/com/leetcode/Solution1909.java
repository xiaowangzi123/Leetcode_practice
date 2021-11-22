package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/22
 * @description : 删除一个元素使数组严格递增
 */
public class Solution1909 {
    public static void main(String[] args) {
        Solution1909 obj = new Solution1909();
//        System.out.println(obj.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(obj.canBeIncreasing(new int[]{2, 3, 1, 2}));
    }

    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                count++;
            }
        }
        return count <= 1;
    }
}
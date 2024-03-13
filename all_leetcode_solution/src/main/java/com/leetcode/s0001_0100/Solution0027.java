package com.leetcode.s0001_0100;

/**
 * 移除元素
 */
public class Solution0027 {
    public static void main(String[] args) {
        Solution0027 obj = new Solution0027();
        System.out.println(obj.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(obj.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

}
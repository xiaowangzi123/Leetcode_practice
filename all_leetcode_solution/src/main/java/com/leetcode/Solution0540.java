package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/2/14
 * @description: 有序数组中的单一元素
 */
public class Solution0540 {
    public static void main(String[] args) {
        Solution0540 obj = new Solution0540();
        System.out.println(obj.singleNonDuplicate(new int[]{}));
    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (m % 2 == 1) {
                m--;
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

}
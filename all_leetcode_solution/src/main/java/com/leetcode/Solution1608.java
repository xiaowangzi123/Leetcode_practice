package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/10
 * @description : 特殊数组的特征值
 */
public class Solution1608 {
    public static void main(String[] args) {
        Solution1608 obj = new Solution1608();
        int[] arr = {3, 5};
        System.out.println(obj.specialArray(arr));
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 0; x <= n; x++) {
            int index = 0;
            while (index < n && nums[index] >= x) {
                index++;
            }
            if (index == x) {
                return x;
            }
        }
        return -1;
    }
}
package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 找到数组的中间位置
 */
public class Solution1991 {
    public static void main(String[] args) {
        Solution1991 obj = new Solution1991();
        System.out.println(obj.findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
        System.out.println(obj.findMiddleIndex(new int[]{1, -1, 4}));
        System.out.println(obj.findMiddleIndex(new int[]{2, 5}));
    }

    public int findMiddleIndex(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            if (sum1 * 2 + nums[i] == sum) {
                return i;
            }
            sum1 += nums[i];
        }
        return -1;
    }

}
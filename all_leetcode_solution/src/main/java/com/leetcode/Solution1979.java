package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 找出数组的最大公约数
 */
public class Solution1979 {
    public static void main(String[] args) {
        Solution1979 obj = new Solution1979();
        System.out.println(obj.findGCD(new int[]{1, 2, 3}));
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0], b = nums[nums.length - 1];
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
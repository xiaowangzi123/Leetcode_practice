package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/24
 * @description : 逐步求和得到正数的最小值
 */
public class Solution1413 {
    public static void main(String[] args) {
        Solution1413 obj = new Solution1413();
        int[] arr = {-3, 2, -3, 4, 2};
        System.out.println(obj.minStartValue(arr));
    }

    public int minStartValue(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, 1 - sum);
        }
        return max;
    }
}
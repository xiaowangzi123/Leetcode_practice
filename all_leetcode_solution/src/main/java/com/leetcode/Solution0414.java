package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/16
 * @description：
 */
public class Solution0414 {
    public static void main(String[] args) {
        Solution0414 obj = new Solution0414();
        int[] arr = {1, 2, 3, 1};
        System.out.println(obj.thirdMax(arr));
        System.out.println(Integer.MIN_VALUE);
    }

    public int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
            } else if (i > b && i < a) {
                c = b;
                b = i;

            } else if (i > c && i < b) {
                c = i;
            }
        }
        return c == Integer.MIN_VALUE ? a : c;
    }
}
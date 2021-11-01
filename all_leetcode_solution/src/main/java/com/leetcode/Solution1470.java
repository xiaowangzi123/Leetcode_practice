package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description： 重新排列数组
 */
public class Solution1470 {
    public static void main(String[] args) {
        Solution1470 obj = new Solution1470();
        int[] arrs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(obj.shuffle(arrs, 5)));
    }

    //此处参数n=nums.length/2
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] res = new int[len];
        int j = 0;
        for (int i = 0; i < len/2; i++) {
            res[j++] = nums[i];
            res[j++] = nums[n++];
        }
        return res;
    }
}
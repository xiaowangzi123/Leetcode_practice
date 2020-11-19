package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[] arrs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.shuffle(arrs, 5)));
    }

    //此处参数n=nums.length/2
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int j = -1;
        for (int i = 0; i < nums.length / 2; i++) {
            res[++j] = nums[i];
            res[++j] = nums[n++];
        }
        return res;
    }
}
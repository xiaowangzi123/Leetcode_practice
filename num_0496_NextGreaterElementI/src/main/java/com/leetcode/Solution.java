package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/12
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] a = {4, 1, 2}, b = {1, 3, 4, 2};
        System.out.println(Arrays.toString(obj.nextGreaterElement(a, b)));
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (findNums[i] == nums[j]) {
                    int k = j + 1;
                    for (; k < nums.length; k++) {
                        if (findNums[i] < nums[k]) {
                            res[i] = nums[k];
                            break;
                        }
                    }
                    if (k == nums.length) res[i] = -1;
                }
            }
        }
        return res;
    }
}
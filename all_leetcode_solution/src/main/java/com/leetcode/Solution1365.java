package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1365 {

    public static void main(String[] args) {
        Solution1365 obj = new Solution1365();
        int[] arr = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(obj.smallerNumbersThanCurrent(arr)));
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
                res[i] = count;
            }
        }
        return res;
    }


}
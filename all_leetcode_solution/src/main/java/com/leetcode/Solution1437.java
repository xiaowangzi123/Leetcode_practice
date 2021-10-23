package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 是否所有 1 都至少相隔 k 个元素
 */
public class Solution1437 {
    public static void main(String[] args) {
        Solution1437 obj = new Solution1437();
        int[] arr = {1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(obj.kLengthApart(arr, 2));
        System.out.println(obj.kLengthApart2(arr, 2));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (index != -1 && i - index - 1 < k) {
                    return false;
                }
                index = i;
            }
        }
        return true;
    }

    public boolean kLengthApart2(int[] nums, int k) {
        int index = -1, i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                if (index >= 0 && i - index - 1 < k) {
                    return false;
                }
                index = i;
            }
            i++;
        }
        return true;
    }


}
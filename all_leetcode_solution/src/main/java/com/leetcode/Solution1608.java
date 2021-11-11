package com.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author :wyq
 * @date ：Created in 2021/11/10
 * @description : 特殊数组的特征值
 */
public class Solution1608 {
    public static void main(String[] args) {
        Solution1608 obj = new Solution1608();
//        int[] arr = {3, 5};
        int[] arr = {0, 4, 3, 0, 4};
        System.out.println(obj.specialArray(arr));
    }

    /**
     *
     */
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = n; x >= 0; x--) {
            int index = n;
            while (index > 0 && nums[index - 1] >= x) {
                index--;
            }
            if (n - index == x) {
                return x;
            }
        }
        return -1;
    }
}
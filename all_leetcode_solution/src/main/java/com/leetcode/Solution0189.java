package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/2/4
 */
public class Solution0189 {
    public static void main(String[] args) {
        Solution0189 obj = new Solution0189();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        obj.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

    }

    //超时
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i]= nums[i-1];
                nums[i-1]=temp;
            }
            k--;
        }
    }
}
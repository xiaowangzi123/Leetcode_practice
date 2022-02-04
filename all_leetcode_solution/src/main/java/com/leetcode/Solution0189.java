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
        obj.rotate2(arr, 3);
        System.out.println(Arrays.toString(arr));

    }

    //超时
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
            k--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; ++i) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
        /*for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }*/
    }
}
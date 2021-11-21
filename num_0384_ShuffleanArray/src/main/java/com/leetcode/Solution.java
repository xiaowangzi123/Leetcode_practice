package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2021/11/22
 * @description: 打乱数组
 */
public class Solution {
    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.reset()));
    }

    int[] arr;
    int[] arr2;

    public Solution(int[] nums) {
        this.arr = nums;
        this.arr2 = nums.clone();
    }

    public int[] reset() {
        System.arraycopy(arr2, 0, arr, 0, arr.length);
        return arr;
    }

    public int[] shuffle() {

        return arr;
    }
}

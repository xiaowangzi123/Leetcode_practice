package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :山脉数组的峰顶索引
 */
public class Solution0852 {
    public static void main(String[] args) {
        Solution0852 obj = new Solution0852();
        int[] arr = {0, 2, 1, 0};
        System.out.println(obj.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
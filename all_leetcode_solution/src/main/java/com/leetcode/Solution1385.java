package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 两个数组间的距离值
 */
public class Solution1385 {
    public static void main(String[] args) {
        Solution1385 obj = new Solution1385();
        int[] arr1 = {4, 5, 8}, arr2 = {10, 9, 1, 8};
        System.out.println(obj.findTheDistanceValue(arr1, arr2, 2));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int temp = 1;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    temp = 0;
                    break;
                }
            }
            count += temp;
        }
        return count;
    }
}
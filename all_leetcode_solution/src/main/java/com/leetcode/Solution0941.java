package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 有效的山脉数组
 */
public class Solution0941 {
    public static void main(String[] args) {
        Solution0941 obj = new Solution0941();
//        int[] arr = {1, 2, 3, 1};
        int[] arr = {2, 3, 3};
        System.out.println(obj.validMountainArray(arr));
    }

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 3) {
            return false;
        }
        int index = 1;
        while (index < n - 1) {
            boolean b1 = true, b2 = true;
            for (int i = 0; i < index; i++) {
                if (arr[i] >= arr[i + 1]) {
                    b1 = false;
                    break;
                }
            }
            for (int i = index; i < n - 1; i++) {
                if (arr[i] <= arr[i + 1]) {
                    b2 = false;
                    break;
                }
            }
            if (b1 && b2) {
                return true;
            }
            index++;
        }

        return false;
    }
}
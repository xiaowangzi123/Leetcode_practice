package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 两个数组间的距离值
 */
public class Solution1385 {
    public static void main(String[] args) {
        Solution1385 obj = new Solution1385();
//        int[] arr1 = {4, 5, 8}, arr2 = {10, 9, 1, 8};
        int[] arr1 = {-3, 2, -5, 7, 1}, arr2 = {4};
        System.out.println(obj.findTheDistanceValue(arr1, arr2, 84));
        System.out.println(obj.findTheDistanceValue2(arr1, arr2, 84));

        int[] t = {1, 3, 5, 9, 21};
        System.out.println(Arrays.binarySearch(t, 4));
        System.out.println(Arrays.binarySearch(t, 3));
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


    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int count = 0, n2 = arr2.length;
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            int index = 0;
            while (index < n2) {
                if (arr2[index] > arr1[i]) {
                    break;
                }
                index++;
            }
            boolean flag = false;
            if (index == 0) {
                flag = Math.abs(arr1[i] - arr2[index]) > d;
            } else if (index == n2) {
                flag = Math.abs(arr1[i] - arr2[index - 1]) > d;
            } else if (Math.abs(arr1[i] - arr2[index]) > d && Math.abs(arr1[i] - arr2[index - 1]) > d) {
                flag = true;
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
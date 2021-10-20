package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 删除某些元素后的数组均值
 */
public class Solution1619 {
    public static void main(String[] args) {
        Solution1619 obj = new Solution1619();
//        int[] arr = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        int[] arr = {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
        System.out.println(obj.trimMean(arr));
    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = arr.length / 20; i < arr.length - arr.length / 20; i++) {
            sum += arr[i];
        }
        double avg = sum / (arr.length - arr.length *0.1);
        return avg;
    }
}
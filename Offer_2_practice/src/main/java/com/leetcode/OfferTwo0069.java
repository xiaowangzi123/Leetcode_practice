package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/10/14
 * @description :山峰数组的顶部
 * 题目数据保证arr是一个山脉数组
 */
public class OfferTwo0069 {
    public static void main(String[] args) {
        OfferTwo0069 obj = new OfferTwo0069();
        int[] arr = {1, 3, 5, 4, 2};
        System.out.println(obj.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1]>arr[i]){
                return i-1;
            }
        }
        return -1;
    }
}
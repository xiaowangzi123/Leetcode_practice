package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/12
 * @description : 卡车上的最大单元数
 */
public class Solution1710 {
    public static void main(String[] args) {
        Solution1710 obj = new Solution1710();
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(obj.maximumUnits(boxTypes, 10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int count = 0;
        for (int[] arr : boxTypes) {
            if (arr[0] < truckSize) {
                truckSize -= arr[0];
                count += arr[0] * arr[1];
            }else {
                count+=truckSize*arr[1];
                break;
            }
        }
        return count;
    }
}
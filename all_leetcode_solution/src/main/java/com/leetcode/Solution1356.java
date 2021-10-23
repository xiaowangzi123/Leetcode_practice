package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 根据数字二进制下 1 的数目排序
 */
public class Solution1356 {
    public static void main(String[] args) {
        Solution1356 obj = new Solution1356();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(obj.sortByBits(arr)));
    }

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = Integer.bitCount(arr[i]);
        }
//        Arrays.sort(arr, (o1, o2) -> (map.get(o1).equals(map.get(o2)) ? (o1-o2) : (map.get(o1) - map.get(o2))));

        Arrays.sort(temp, (a, b) -> (a[1] == b[1] ? a[1] - b[1] : a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            arr[i]=temp[i][0];
        }
        return arr;
    }
}
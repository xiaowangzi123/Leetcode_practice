package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 复写零
 */
public class Solution1089 {
    public static void main(String[] args) {
        Solution1089 obj = new Solution1089();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        obj.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 0, 2, 3, 0, 4, 5, 0};
        obj.duplicateZeros2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public void duplicateZeros(int[] arr) {
        int index = 0, n = arr.length;
        while (index < n) {
            if (arr[index] == 0) {
                for (int i = n - 1; i > index; i--) {
                    arr[i] = arr[i - 1];
                }
                index++;
            }
            index++;
        }
    }

    public void duplicateZeros2(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
            if (arr[i] == 0) {
                list.add(arr[i]);
            }
            arr[i] = list.get(i);
        }
    }

}
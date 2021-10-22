package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 将每个元素替换为右侧最大元素
 */
public class Solution1299 {
    public static void main(String[] args) {
        Solution1299 obj = new Solution1299();
        int[] arr = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(obj.replaceElements(arr)));
        int[] arr2 = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(obj.replaceElements2(arr2)));
    }

    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                }
            }
        }
        arr[n - 1] = -1;
        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        return ans;
    }
}
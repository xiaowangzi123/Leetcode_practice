package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/29
 * @description : 路径交叉
 */
public class Solution0335 {
    public static void main(String[] args) {
        Solution0335 obj = new Solution0335();
        int[] distance = {};
        System.out.println(obj.isSelfCrossing(distance));
    }

    public boolean isSelfCrossing(int[] arr) {
        int n = arr.length;
        if (n < 4) {
            return false;
        }
        for (int i = 3; i < n; i++) {
            if (arr[i] >= arr[i - 2] && arr[i - 1] <= arr[i - 3]) {
                return true;
            }
            if (i >= 4 && arr[i - 1] == arr[i - 3] && arr[i] + arr[i - 4] >= arr[i - 2]) {
                return true;
            }
            if (i >= 5 && arr[i - 1] <= arr[i - 3] && arr[i - 2] > arr[i - 4]
                    && arr[i] + arr[i - 4] >= arr[i - 2] && arr[i - 1] + arr[i - 5] >= arr[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
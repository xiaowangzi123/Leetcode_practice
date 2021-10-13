package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :通过翻转子数组使两个数组相等
 */
public class Solution1460 {
    public static void main(String[] args) {
        Solution1460 obj = new Solution1460();
        int[] target = {1, 2, 3, 4}, arr = {2, 4, 1, 3};
        System.out.println(obj.canBeEqual(target, arr));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }


}
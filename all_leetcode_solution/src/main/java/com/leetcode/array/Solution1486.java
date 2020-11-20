package com.leetcode.array;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1486 {

    public static void main(String[] args) {
        Solution1486 obj = new Solution1486();
        System.out.println(obj.xorOperation(0, 5));
    }


    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = start + i * 2;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public int xorOperation2(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }

}
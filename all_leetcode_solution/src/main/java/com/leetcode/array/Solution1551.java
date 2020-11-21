package com.leetcode.array;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1551 {

    public static void main(String[] args) {
        Solution1551 obj = new Solution1551();

        System.out.println(obj.minOperations(3));
    }


    public int minOperations(int n) {
        int m = n / 2;
        if (n % 2 == 1) {
            return m * (m + 1);
        } else {
            return m * m;
        }
    }


}
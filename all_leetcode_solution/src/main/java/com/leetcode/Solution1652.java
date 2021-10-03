package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/17
 * @description :
 */
public class Solution1652 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = -2;
        Solution1652 obj = new Solution1652();
        System.out.println(Arrays.toString(obj.decrypt(arr, k)));

    }

    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        }

        int start = 1, sum = 0;
        if (k < 0) {
            start = code.length + k;
            k = code.length - 1;
        }
        //第一个元素值sum
        for (int i = start; i <= k; i++) {
            sum += code[i];
        }

        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++k) % code.length];
        }
        return res;
    }
}
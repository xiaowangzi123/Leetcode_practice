package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/17
 * @description : 拆炸弹
 */
public class Solution1652 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = -2;
        Solution1652 obj = new Solution1652();
        System.out.println(Arrays.toString(obj.decrypt(arr, k)));
        System.out.println(Arrays.toString(obj.decrypt2(arr, k)));

    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        //k=0直接返回值全为0的数组
        if (k == 0) {
            return res;
        }

        int start = 1, sum = 0;
        if (k < 0) {
            start = n + k;
            k = n - 1;
        }
        //第一个元素值sum
        for (int i = start; i <= k; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            res[i] = sum;
            //减去当前元素值
            sum -= code[(start++) % n];
            //加上下一元素，此时sum表示（i+1）元素的值
            sum += code[(++k) % n];
        }
        return res;
    }


    public int[] decrypt2(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }

        for (int i = 0; i < n; i++) {
            res[i] = 0;
            if (k < 0) {
                for (int j = i + n - 1; j >= i + k + n; j--) {
                    res[i] += code[j % n];
                }
            }
            if (k > 0) {
                for (int j = i + n + 1; j <= i + k + n; j++) {
                    res[i] += code[j % n];
                }
            }
        }
        return res;
    }
}
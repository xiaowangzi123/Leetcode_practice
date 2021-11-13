package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/13
 * @description : 解码异或后的数组
 */
public class Solution1720 {
    public static void main(String[] args) {
        Solution1720 obj = new Solution1720();
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(obj.decode(arr, 1)));
    }

    /**
     * 异或运算具有如下性质：
     * <p>
     * 1.异或运算满足交换律和结合律；
     * 2.任意整数和自身做异或运算的结果都等于 0，即 x^x =0;
     * 任意整数和 0 做异或运算的结果都等于其自身，即 x^0 = 0^x = x。
     */
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        ans[0] = first;
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
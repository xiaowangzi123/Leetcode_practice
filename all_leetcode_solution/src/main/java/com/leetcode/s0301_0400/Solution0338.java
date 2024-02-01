package com.leetcode.s0301_0400;

import java.util.Arrays;

/**
 * 比特位计数
 */
public class Solution0338 {
    public static void main(String[] args) {
        Solution0338 obj = new Solution0338();
        System.out.println(Arrays.toString(obj.countBits(3)));

        obj.countOnes(10);
    }

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++){
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    /**
     * 对于任意整数 x，令 x=x&(x−1)，该运算将 x 的二进制表示的最后一个 1变成 0。
     */
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

}
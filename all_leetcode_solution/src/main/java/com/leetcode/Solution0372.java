package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/12/5
 * @description : 超级次方
 */
public class Solution0372 {
    public static void main(String[] args) {
        Solution0372 obj = new Solution0372();
        System.out.println(obj.superPow(2, new int[]{3}));
        System.out.println(obj.superPow(2, new int[]{1, 0}));
        System.out.println(obj.superPow(2147483647, new int[]{2, 0, 0}));
    }

    /**
     * 超时
     */
    public int superPow(int a, int[] b) {
        int n = b.length, ans = 1, temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            int m = b[i] * temp;
            for (int j = 0; j < m; j++) {
                ans *= (a % 1337);
                ans %= 1337;
            }
            temp *= 10;
        }

        return ans;
    }
}
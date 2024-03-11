package com.leetcode.s0001_0100;

/**
 * Pow(x, n)递归
 */
public class Solution0050 {
    public static void main(String[] args) {
        Solution0050 obj = new Solution0050();
        System.out.println(obj.myPow(2, 10));
        System.out.println(obj.myPow2(2, 10));
        int n = 5;
        System.out.println(n / 2);
        long n2 = n / 2;
        System.out.println(n2);
    }

    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    //递归
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long l = n;
        return l >= 0 ? quickMult2(x, l) : 1 / quickMult2(x, -l);
    }

    public double quickMult(double x, long l) {
        if (l == 0) {
            return 1;
        }
        double temp = quickMult(x, l / 2);
        return l % 2 == 0 ? temp * temp : temp * temp * x;
    }

    /**
     *
     */
    public double quickMult2(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
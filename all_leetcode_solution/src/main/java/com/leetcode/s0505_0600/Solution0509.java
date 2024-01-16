package com.leetcode.s0505_0600;

/**
 * 斐波那契数
 */
public class Solution0509 {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


}

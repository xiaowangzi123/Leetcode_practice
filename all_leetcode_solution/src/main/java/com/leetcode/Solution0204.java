package com.leetcode;

import java.io.Console;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/11
 * @description：
 */
public class Solution0204 {
    public static void main(String[] args) {
        Solution0204 obj = new Solution0204();
        System.out.println(obj.countPrimes(10));
        System.out.println(obj.countPrimes(1));
        System.out.println(obj.countPrimes(2));
        System.out.println(obj.countPrimes(3));
        System.out.println(obj.countPrimes(4));
        
        long t1 = System.currentTimeMillis();
        System.out.println(obj.countPrimes(5000000));
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1)/1000);
    }

    //有超时的可能
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrimes(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
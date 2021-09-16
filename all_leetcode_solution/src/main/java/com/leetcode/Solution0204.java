package com.leetcode;

import java.io.Console;
import java.util.Arrays;

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
        System.out.println("500000:yi=="+obj.countPrimes(5000000));
        long t2 = System.currentTimeMillis();
        System.out.println("yi："+(t2 - t1) / 1000);


        long t3 = System.currentTimeMillis();
        System.out.println("500000:er=="+obj.countPrimes2(5000000));
        long t4 = System.currentTimeMillis();
        System.out.println("二："+(t4 - t3) / 1000);
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
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes2(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j+=i) {
                    isPrimes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }
}
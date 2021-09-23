package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/23
 * @description：
 */
public class Solution0362 {
    public static void main(String[] args) {
        Solution0362 obj = new Solution0362();
        System.out.println(obj.isPowerOfThree(27));
        System.out.println(obj.isPowerOfThree(30));
    }

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
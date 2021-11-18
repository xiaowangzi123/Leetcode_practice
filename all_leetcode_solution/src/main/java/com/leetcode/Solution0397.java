package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/19
 * @description : 整数替换
 */
public class Solution0397 {
    public static void main(String[] args) {
        Solution0397 obj = new Solution0397();
        System.out.println(obj.integerReplacement(7));
        System.out.println(obj.integerReplacement(8));
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2 + 1), integerReplacement(n / 2));
    }
}
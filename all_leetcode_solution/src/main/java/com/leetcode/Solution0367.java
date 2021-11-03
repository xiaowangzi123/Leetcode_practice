package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/4
 * @description : 有效的完全平方数
 */
public class Solution0367 {
    public static void main(String[] args) {
        Solution0367 obj = new Solution0367();
        System.out.println(obj.isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        for (int i = 0; i < num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
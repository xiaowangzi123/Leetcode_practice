package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/3/21
 * @description: TODO
 * 693. 交替位二进制数
 */
public class Solution0693 {
    public static void main(String[] args) {
        Solution0693 obj = new Solution0693();
        System.out.println(obj.hasAlternatingBits(5));
        System.out.println(obj.hasAlternatingBits(7));
        System.out.println(obj.hasAlternatingBits(11));
    }

    public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }
    public boolean hasAlternatingBits2(int n) {
        int prev = 2;
        while (n != 0) {
            int cur = n % 2;
            if (cur == prev) {
                return false;
            }
            prev = cur;
            n /= 2;
        }
        return true;
    }

}
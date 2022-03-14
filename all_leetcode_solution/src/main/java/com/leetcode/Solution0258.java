package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/3/3
 * @description: 各位相加
 */
public class Solution0258 {
    public static void main(String[] args) {
        Solution0258 obj = new Solution0258();
        System.out.println(obj.addDigits(38));
        System.out.println(obj.addDigits(12345));
    }

    public int addDigits(int num) {
        while (num > 9) {
            int ans = 0;
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
            num = ans;
        }
        return num;
    }
}
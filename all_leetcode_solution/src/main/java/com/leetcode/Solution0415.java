package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0415 {
    public static void main(String[] args) {
        Solution0415 obj = new Solution0415();
        String num1 = "11", num2 = "123";
        System.out.println(obj.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int m=Integer.parseInt(num1),n=Integer.parseInt(num2);
        return String.valueOf(m+n);
    }
}
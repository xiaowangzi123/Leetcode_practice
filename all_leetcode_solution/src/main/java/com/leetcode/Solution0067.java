package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0067 {
    public static void main(String[] args) {
        Solution0067 obj = new Solution0067();
        String a = "1010", b = "1011";
        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }



}
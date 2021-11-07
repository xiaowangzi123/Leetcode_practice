package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 字符串中的最大奇数
 */
public class Solution1903 {
    public static void main(String[] args) {
        Solution1903 obj = new Solution1903();
        System.out.println(obj.largestOddNumber("35427"));
        System.out.println(obj.largestOddNumber("3542"));
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
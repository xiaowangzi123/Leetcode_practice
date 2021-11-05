package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/5
 * @description : 千位分隔数
 */
public class Solution1556 {
    public static void main(String[] args) {
        Solution1556 obj = new Solution1556();
        System.out.println(obj.thousandSeparator(0));
        System.out.println(obj.thousandSeparator(123));
        System.out.println(obj.thousandSeparator(12345));
        System.out.println(obj.thousandSeparator(123456789));
    }

    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n > 0) {
            sb.append(n % 10);
            count++;
            n /= 10;
            if (count % 3 == 0 && n != 0) {
                sb.append(".");
                count = 0;
            }
        }
        return sb.reverse().toString();
    }
}
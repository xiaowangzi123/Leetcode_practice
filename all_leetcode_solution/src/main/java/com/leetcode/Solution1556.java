package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/5
 * @description : 千位分隔数
 */
public class Solution1556 {
    public static void main(String[] args) {
        Solution1556 obj = new Solution1556();
        System.out.println(obj.thousandSeparator(123));
    }

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 10);
            n /= 10;
            if (sb.length() % 3 == 0) {
                sb.append(".");
            }
        }

        if (sb.length() % 4 == 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}
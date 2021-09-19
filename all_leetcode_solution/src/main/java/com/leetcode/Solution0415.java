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

        String num3 = "435", num4 = "88";
        System.out.println(obj.addStrings2(num3, num4));
    }

    public String addStrings(String num1, String num2) {
        int m = Integer.parseInt(num1), n = Integer.parseInt(num2);
        return String.valueOf(m + n);
    }

    public String addStrings2(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int m = num1.length() - 1, n = num2.length() - 1, k = 0;
        while (m >= 0 || n >= 0) {
            int i = m >= 0 ? num1.charAt(m) - '0' : 0;
            int j = n >= 0 ? num2.charAt(n) - '0' : 0;
            sb.append((i + j + k) % 10);
            k = (i + j + k) / 10;
            m--;
            n--;
        }
        if (k == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
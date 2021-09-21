package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/21
 * @description： {@link Solution0415}
 */
public class Solution0043 {
    public static void main(String[] args) {
        Solution0043 obj = new Solution0043();
        String num1 = "123", num2 = "456";
        System.out.println(obj.multiply(num1, num2));
    }

    /**
     * 计算形式
     * num1
     * * num2
     * ------
     * result
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
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
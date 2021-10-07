package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/11
 * @description : Excel表列名称
 *
 * {@link Solution0171}
 */
public class Solution0168 {
    public static void main(String[] args) {
        Solution0168 obj = new Solution0168();
        System.out.println("Z==" + obj.convertToTitle(26));
        System.out.println("AB==" + obj.convertToTitle(28));
        System.out.println("AZ==" + obj.convertToTitle(52));
        System.out.println("ZY==" + obj.convertToTitle(701));
        System.out.println("FXSHRXW==" + obj.convertToTitle(2147483647));

        System.out.println((char) (27 % 26 + 'A'));
        System.out.println((char) (26 % 26 + '@'));
        System.out.println((char) (27 % 26 + '@'));
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) (columnNumber % 26 + 'A');
            sb.append(ch);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public String convertToTitle2(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char) ((n % 26) + 'A' - 1));
            }
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
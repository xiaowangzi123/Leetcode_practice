package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/2/25
 * @description: TODO
 * 复数乘法
 */
public class Solution0537 {
    public static void main(String[] args) {
        Solution0537 obj = new Solution0537();
        System.out.println(obj.complexNumberMultiply("1+1i", "1+1i"));
    }

    public String complexNumberMultiply(String num1, String num2) {
        String[] str1 = num1.split("[+i]");
        String[] str2 = num2.split("\\+|i");
        int x1 = Integer.parseInt(str1[0]);
        int y1 = Integer.parseInt(str1[1]);
        int x2 = Integer.parseInt(str2[0]);
        int y2 = Integer.parseInt(str2[1]);

        StringBuilder sb = new StringBuilder();
        sb.append(x1 * x2 - y1 * y2).append("+").append(x1 * y2 + x2 * y1).append("i");
        return sb.toString();

    }

}
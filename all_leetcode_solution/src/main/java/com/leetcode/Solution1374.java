package com.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * @author :wyq
 * @date ：Created in 2021/11/1
 * @description : 生成每种字符都是奇数个的字符串
 */
public class Solution1374 {
    public static void main(String[] args) {
        Solution1374 obj = new Solution1374();
        System.out.println(obj.generateTheString(4));
        System.out.println(obj.generateTheString2(4));
        System.out.println(obj.generateTheString3(4));
        System.out.println(obj.generateTheString4(4));
        System.out.println("------------------");

        System.out.println(obj.generateTheString(5));
        System.out.println(obj.generateTheString2(5));
        System.out.println(obj.generateTheString3(5));
        System.out.println(obj.generateTheString4(5));
    }

    /**
     * repeat需要java10以上版本
     * StringUtils.repeat需要引入org.apache.commons.lang3包
     */
    public String generateTheString(int n) {
//        return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
        return "b" + StringUtils.repeat("ab".substring(n % 2, 1 + n % 2), n - 1);
    }

    public String generateTheString2(int n) {
        String repeated = "b" + new String(new char[n - 1]).replace("\0", "ab".substring(n % 2, 1 + n % 2));
        return repeated;
    }

    public String generateTheString3(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("b");
        String s = "ab".substring(n % 2, 1 + n % 2);
        for (int i = 0; i < n - 1; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String generateTheString4(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("b");
        }
        if (n % 2 == 0) {
            sb.replace(0, 1, "a");
        }
        return sb.toString();
    }
}
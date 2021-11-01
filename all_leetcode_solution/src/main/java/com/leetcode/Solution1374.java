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
        System.out.println(obj.generateTheString(3));
        System.out.println(obj.generateTheString(5));
    }

    public String generateTheString(int n) {
//        return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
        return "b" + StringUtils.repeat("ab".substring(n % 2, 1 + n % 2),n-1);

    }
}
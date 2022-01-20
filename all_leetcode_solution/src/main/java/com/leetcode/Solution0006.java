package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/1/20
 * @description: Z 字形变换
 */
public class Solution0006 {
    public static void main(String[] args) {
        Solution0006 obj = new Solution0006();
//        System.out.println(obj.convert("0123456789abcdefghiJKL", 4));
//        System.out.println(obj.convert2("0123456789abcdefghiJKL", 4));
        System.out.println(obj.convert("0123456789abcdefghi", 4));
        System.out.println(obj.convert2("0123456789abcdefghi", 4));
    }


    /**
     *
     */
    public String convert(String s, int num) {
        if (num == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length(), step = 2 * (num - 1);
        for (int i = 0; i < num; i++) {
            if (i == 0) {//第一行
                for (int j = 0; j + i < n; j += step) {
                    sb.append(s.charAt(j + i));
                }
            } else if (i == num - 1) {//最后一行
                for (int j = 0; j + i < n; j += step) {
                    sb.append(s.charAt(j + i));
                }
            } else {//中间行
                for (int j = 0; j + i < n; j += step) {
                    sb.append(s.charAt(j + i));
                    if (j + step - i < n) {
                        sb.append(s.charAt(j + step - i));
                    }
                }
            }
        }

        return sb.toString();
    }


    //优化版
    public String convert2(String s, int num) {
        if (num == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length(), step = 2 * (num - 1);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j + i < n; j += step) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != num - 1 && j + step - i < n) {
                    sb.append(s.charAt(j + step - i));
                }
            }
        }
        return sb.toString();
    }
}
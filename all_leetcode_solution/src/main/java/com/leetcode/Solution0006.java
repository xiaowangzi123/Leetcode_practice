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
        System.out.println(obj.convert("0123456789abcdefghi", 4));
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
            if (i == 0) {
                for (int j = 0; step * j + i < n; j++) {
                    sb.append(s.charAt(step * j));
                }
            } else if (i == num - 1) {
                for (int j = 0; step * j + i < n; j++) {
                    sb.append(s.charAt(step * j + i));
                }
            } else {
                for (int j = 0; step * j + i < n; j++) {
                    if (j > 0) {
                        sb.append(s.charAt(step * j - i));
                    }
                    sb.append(s.charAt(step * j + i));
                }
            }
        }

        return sb.toString();
    }
}
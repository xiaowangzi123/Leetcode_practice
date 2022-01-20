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
    public String convert(String s, int k) {
        if (k == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                for (int j = 0; (k - 1) * j < n; j += 2) {
                    sb.append(s.charAt((k - 1) * j));
                }
            } else if (i == k - 1) {
                for (int j = 1; (k - 1) * j < n; j += 2) {
                    sb.append(s.charAt((k - 1) * j));
                }
            } else {
                for (int j = 0; (k - 1) * j < n; j += 2) {
                    if ((k - 1) * j + i < n) {
                        sb.append(s.charAt((k - 1) * j + i));
                    }
                    sb.append(s.charAt((k - 1) * j - i));
                }
            }
        }

        return sb.toString();
    }
}
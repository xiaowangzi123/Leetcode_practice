package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/1
 * @description : 删除字符使字符串变好
 */
public class Solution1957 {
    public static void main(String[] args) {
        Solution1957 obj = new Solution1957();
        String s = "leeetcode";
        System.out.println(obj.makeFancyString(s));
    }

    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, 2);
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
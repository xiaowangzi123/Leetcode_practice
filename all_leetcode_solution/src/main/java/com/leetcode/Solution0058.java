package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/5
 * @description：
 */
public class Solution0058 {
    public static void main(String[] args) {
        Solution0058 obj = new Solution0058();
        String s = "Hello World";
        String s2 = " ";
        System.out.println(obj.lengthOfLastWord(s));
        System.out.println(obj.lengthOfLastWord(s2));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        return s.substring(start).length();
    }
}
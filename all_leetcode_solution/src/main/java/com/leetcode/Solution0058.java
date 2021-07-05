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
        String[] temp = s.split(" ");
        int i = 0;
        for (String x : temp) {
            i = Math.max(i, x.length());
        }
        return i;
    }
}
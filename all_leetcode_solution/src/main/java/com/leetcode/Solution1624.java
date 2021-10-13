package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :两个相同字符之间的最长子字符串
 */
public class Solution1624 {
    public static void main(String[] args) {
        Solution1624 obj = new Solution1624();
        System.out.println(obj.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("cbzxy"));
        
        System.out.println("-------------");
        String st = "abcdefa";
        System.out.println(st.indexOf("a"));
        System.out.println(st.indexOf("g"));
        System.out.println(st.lastIndexOf("a"));
    }


    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        for (char ch : s.toCharArray()) {
            int index = s.indexOf(ch), index2 = s.lastIndexOf(ch);
            if (index2 != -1) {
                max = Math.max(max, index2 - index - 1);
            }
        }

        return max;
    }
}
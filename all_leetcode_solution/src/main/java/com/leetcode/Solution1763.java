package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :最长的美好子字符串
 */
public class Solution1763 {
    public static void main(String[] args) {
        Solution1763 obj = new Solution1763();

        String s = "YazaAay";
        System.out.println(obj.longestNiceSubstring(s));
        System.out.println("----------------------------");

        System.out.println(Character.isLowerCase('Y'));
        System.out.println(s.substring(3, 6));
        System.out.println("-----------------------------");
        
        System.out.println(obj.isLongFineString("b"));
        System.out.println(obj.isLongFineString("bBb"));
    }


    public String longestNiceSubstring(String s) {
        String ans = "";
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String temp = s.substring(i, j);
                boolean flag = isLongFineString(temp);
                if (flag && j - i > l) {
                    l = j - i;
                    ans = temp;
                }
            }
        }
        return ans;
    }

    public boolean isLongFineString(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        for (char ch : s.toCharArray()) {
            boolean b1 = set.contains(Character.toLowerCase(ch));
            boolean b2 = set.contains(Character.toUpperCase(ch));
            if (!b1 || !b2) {
                return false;
            }
        }
        return true;
    }
}
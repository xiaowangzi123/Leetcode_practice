package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/2/1
 * @description: 最长的美好子字符串
 */
public class Solution1763 {
    public static void main(String[] args) {
        Solution1763 obj = new Solution1763();

//        String s = "YazaAay";
//        String s = "Bb";
        System.out.println(obj.longestNiceSubstring("dDzeE"));
        System.out.println(obj.longestNiceSubstring2("dDzeE"));
        System.out.println("-----------------------------");

        System.out.println(obj.isLongFineString("b"));
        System.out.println(obj.isLongFineString("bBb"));
    }


    public String longestNiceSubstring(String s) {
        String ans = "";
        int l = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
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

    public String longestNiceSubstring2(String s) {
        int n = s.length();
        if (n < 2) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (set.contains(Character.toLowerCase(temp)) && set.contains(Character.toUpperCase(temp))) {
                continue;
            }
            String s1 = longestNiceSubstring2(s.substring(0, i));
            String s2 = longestNiceSubstring2(s.substring(i + 1));
            return s1.length() >= s2.length() ? s1 : s2;
        }

        return s;
    }
}
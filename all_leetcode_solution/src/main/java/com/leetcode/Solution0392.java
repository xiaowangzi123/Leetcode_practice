package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0392 {
    public static void main(String[] args) {
        Solution0392 obj = new Solution0392();
        String s = "abc", t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
        System.out.println(obj.isSubsequence2(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int m = 0, n = 0;
        while (m < s.length() && n < t.length()) {
            if (s.charAt(m) == t.charAt(n)) {
                m++;
            }
            n++;
        }
        return m == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
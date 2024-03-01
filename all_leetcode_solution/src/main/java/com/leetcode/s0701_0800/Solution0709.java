package com.leetcode.s0701_0800;

/**
 * 转换成小写字母
 */
public class Solution0709 {
    public static void main(String[] args) {
        Solution0709 obj = new Solution0709();
        System.out.println(obj.toLowerCase3("AdAdA"));
        System.out.println(obj.toLowerCase3("BdCdD"));
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public String toLowerCase2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public String toLowerCase3(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
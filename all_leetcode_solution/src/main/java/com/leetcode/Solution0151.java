package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 翻转字符串里的单词
 */
public class Solution0151 {
    public static void main(String[] args) {
        Solution0151 obj = new Solution0151();

        System.out.println(obj.reverseWords("  the sky is blue  "));
        System.out.println(obj.reverseWords2("th  bl  "));
    }

    public String reverseWords(String s) {
        String[] st = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = st.length - 1; i >= 0; i--) {
            sb.append(st[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return sb.toString().trim();
    }


}
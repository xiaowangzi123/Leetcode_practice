package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 将所有数字用字符替换
 */
public class Solution1844 {
    public static void main(String[] args) {
        Solution1844 obj = new Solution1844();
        System.out.println(obj.replaceDigits("a1c1e1"));

        System.out.println((char) ('a' + 1));
    }

    public String replaceDigits(String s) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i += 2) {
            ch[i] = (char) (ch[i - 1] + ch[i] - '0');
        }
        return new String(ch);
    }
}
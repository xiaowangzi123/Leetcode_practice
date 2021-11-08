package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description :
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Solution0058 {
    public static void main(String[] args) {
        Solution0058 obj = new Solution0058();

        System.out.println(obj.reverseLeftWords("abcdefg", 2));
    }


    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
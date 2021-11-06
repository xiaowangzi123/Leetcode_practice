package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 截断句子
 */
public class Solution1816 {
    public static void main(String[] args) {
        Solution1816 obj = new Solution1816();
        String s = "Hello how are you Contestant";
        System.out.println(obj.truncateSentence(s, 4));
    }

    public String truncateSentence(String s, int k) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
                if (k == 0) {
                    break;
                }
            }
        }
        return s.substring(0, i);
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 检查字符串是否为数组前缀
 */
public class Solution1961 {
    public static void main(String[] args) {
        Solution1961 obj = new Solution1961();
        String s = "iloveleetcodeapp";
        String[] words = {"i", "love", "leetcode", "apples"};
        System.out.println(obj.isPrefixString(s, words));
        System.out.println(obj.isPrefixString2(s, words));
    }

    /**
     * words数组中的单个单词不能只用一半
     */
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String i : words) {
            sb.append(i);
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPrefixString2(String s, String[] words) {
        int index = 0, n = s.length();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (index < n && s.charAt(index) == word.charAt(i)) {
                    index++;
                } else {
                    return false;
                }
            }
            if (index == n) {
                return true;
            }
        }
        return false;
    }
}
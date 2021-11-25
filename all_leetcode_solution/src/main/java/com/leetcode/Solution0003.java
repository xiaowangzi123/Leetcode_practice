package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 无重复字符的最长子串
 */
public class Solution0003 {
    public static void main(String[] args) {
        Solution0003 obj = new Solution0003();
        System.out.println(obj.lengthOfLongestSubstring(""));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                String temp = String.valueOf(s.charAt(j));
                if (sb.toString().contains(temp)) {
                    break;
                } else {
                    sb.append(temp);
                    max = Math.max(max, sb.length());
                }
            }
        }
        return max;
    }

}
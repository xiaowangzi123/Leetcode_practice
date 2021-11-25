package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 无重复字符的最长子串
 */
public class Solution0003 {
    public static void main(String[] args) {
        Solution0003 obj = new Solution0003();
        System.out.println(obj.lengthOfLongestSubstring(""));
        System.out.println(obj.lengthOfLongestSubstring2(""));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring2("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                    max = Math.max(max, set.size());
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            int index = i;
            while (index < n && !set.contains(s.charAt(index))) {
                set.add(s.charAt(index));
                index++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

}
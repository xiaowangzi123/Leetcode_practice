package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description ：找到字符串中所有字母异位词
 */
public class Solution0438 {
    public static void main(String[] args) {
        Solution0438 obj = new Solution0438();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
        System.out.println(obj.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return ans;
        }
        for (int i = 0; i <= m - n; i++) {
            if (stringIsEquals(s.substring(i, i + n), p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean stringIsEquals(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}
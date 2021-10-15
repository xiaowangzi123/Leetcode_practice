package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description : 有效的字母异位词
 */
public class Solution0242 {
    public static void main(String[] args) {
        Solution0242 obj = new Solution0242();
        String s = "anagram", t = "nagaram";
        System.out.println(obj.isAnagram(s, t));
        System.out.println(obj.isAnagram2(s, t));
        System.out.println(obj.isAnagram3(s, t));
    }

    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();

        Arrays.sort(sch);
        Arrays.sort(tch);

        return Arrays.equals(sch, tch);
    }

    public boolean isAnagram3(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char ch : s.toCharArray()) {
            cnt1[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            cnt2[ch - 'a']++;
        }
        return Arrays.equals(cnt1,cnt2);
    }
}
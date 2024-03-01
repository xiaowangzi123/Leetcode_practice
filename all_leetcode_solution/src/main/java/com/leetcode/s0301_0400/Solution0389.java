package com.leetcode.s0301_0400;

/**
 * 找不同
 */
public class Solution0389 {
    public static void main(String[] args) {
        Solution0389 obj = new Solution0389();
        String s = "abcd", t = "abcde";
        System.out.println(obj.findTheDifference(s, t));
        System.out.println(obj.findTheDifference2(s, t));
        System.out.println(obj.findTheDifference3(s, t));


    }

    public char findTheDifference(String s, String t) {
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            res ^= t.charAt(j);
        }

        return res;
    }

    /**
     * 计算每一个字母的数量，比对数量的不同
     */
    public char findTheDifference2(String s, String t) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return (char) ('a' + i);
            }
        }
        return 0;
    }

    /**
     * 后一个字符串字母值相加后减去前一个字符串字母值相加的结果
     */
    public char findTheDifference3(String s, String t) {
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < s.length(); i++) {
            ans1 += s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            ans2 += t.charAt(i);
        }

        return (char) (ans2 - ans1);
    }

}
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description :
 */
public class Solution0389 {
    public static void main(String[] args) {
        Solution0389 obj = new Solution0389();
        String s = "abcd", t = "abcde";
        System.out.println(obj.findTheDifference(s, t));
        System.out.println(obj.findTheDifference2(s, t));


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


}
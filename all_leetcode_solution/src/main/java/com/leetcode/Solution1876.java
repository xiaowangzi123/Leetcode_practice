package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :判断句子是否为全字母句
 */
public class Solution1876 {
    public static void main(String[] args) {
        Solution1876 obj = new Solution1876();
        System.out.println(obj.countGoodSubstrings("xyzzaz"));
        System.out.println(obj.countGoodSubstrings("aababcabc"));
        System.out.println(obj.countGoodSubstrings2("aababcabc"));
        System.out.println("-----------------------------");
    }

    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i + 1) != s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    public int countGoodSubstrings2(String s) {
        int count = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length() - 2; i++) {
            if (ch[i] != ch[i + 1] && ch[i] != ch[i + 2] && ch[i + 1] != ch[i + 2]) {
                count++;
            }
        }
        return count;
    }
}
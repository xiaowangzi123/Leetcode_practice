package com.leetcode;

import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 交替合并字符串
 */
public class Solution1768 {
    public static void main(String[] args) {
        Solution1768 obj = new Solution1768();
        String word1 = "1234", word2 = "ab";
        System.out.println(obj.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            if (i < n1) {
                ans.append(word1.charAt(i));
            }
            if (j < n2) {
                ans.append(word2.charAt(j));
            }
            i++;
            j++;
        }
        return ans.toString();
    }
}
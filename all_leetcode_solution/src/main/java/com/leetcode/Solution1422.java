package com.leetcode;

import org.apache.commons.lang3.StringUtils;

import javax.swing.event.MouseInputAdapter;

/**
 * @author :wyq
 * @date ：Created in 2021/11/3
 * @description : 分割字符串的最大得分
 */
public class Solution1422 {
    public static void main(String[] args) {
        Solution1422 obj = new Solution1422();
        System.out.println(obj.maxScore("011101"));
//        System.out.println(obj.maxScore("11111"));
//        System.out.println(obj.maxScore("00000"));
        System.out.println(obj.maxScore2("11100"));

    }

    public int maxScore(String s) {
        int ans = 0, n = s.length();
        for (int i = 1; i < s.length(); i++) {
            int zero = getZeroCount(s.substring(0, i));
            int one = getOneoCount(s.substring(i, n));
            ans = Math.max(ans, zero + one);
        }
        return ans;
    }

    public int maxScore2(String s) {
        int count = 0, ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                count--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }


    public int getZeroCount(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                count++;
            }
        }
        return count;
    }

    public int getOneoCount(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}
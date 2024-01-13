package com.leetcode.s2101_2200;

import sun.lwawt.macosx.CSystemTray;

/**
 * @author wyq
 * @date 2024/1/13
 * @desc 构造限制重复的字符串
 */
public class Solution2182 {

    public static void main(String[] args) {
        Solution2182 solution = new Solution2182();
        String s = "cczazcc";
        Integer repeatLimit = 3;
        System.out.println(solution.repeatLimitedString(s, repeatLimit));
    }

    public static int SIZE = 26;

    public String repeatLimitedString(String s, int repeatLimit) {
        int count = 0;
        int[] cnt = new int[SIZE];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = SIZE - 1, j = SIZE - 2; i >= 0 && j >= 0; ) {

        }
        return sb.toString();
    }
}

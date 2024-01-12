package com.leetcode.s2601_2700;

/**
 * @author wyq
 * @date 2024/1/12
 * @desc 删除子串后的字符串最小长度
 */
public class Solution2696 {
    public static void main(String[] args) {
        Solution2696 solution =new Solution2696();
        System.out.println(solution.minLength("ABFCACDB"));
    }

    public int minLength(String s) {
        s = s.replaceAll("AB", "");
        s = s.replaceAll("CD", "");
        s = s.replaceAll("AB", "");
        s = s.replaceAll("CD", "");
        return s.length();
    }
}

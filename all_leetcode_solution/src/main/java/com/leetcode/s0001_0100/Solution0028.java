package com.leetcode.s0001_0100;

/**
 * 找出字符串中第一个匹配项的下标
 */
public class Solution0028 {
    public static void main(String[] args) {
        Solution0028 obj = new Solution0028();
        String haystack = "hello", needle = "ll";
//        System.out.println(obj.strStr(haystack, needle));
        System.out.println(obj.strStr(haystack, needle));
        System.out.println(obj.strStr2(haystack, needle));
        System.out.println(haystack.indexOf(needle));
    }

    //需要改进
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i + n < m; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    return -1;
                }
            }
            return i;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        char[] mm = haystack.toCharArray(), nn = needle.toCharArray();
        for (int i = 0; i <= m - n; i++) {
            int a = i, b = 0;
            while (b < n && mm[a] == nn[b]) {
                a++;
                b++;
            }
            if (b == n) {
                return i;
            }
        }
        return -1;
    }

}
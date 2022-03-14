package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/11
 * @description :最长特殊序列 Ⅰ
 * 最长特殊序列：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 字符串s的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
 */
public class Solution0521 {
    public static void main(String[] args) {
        Solution0521 obj = new Solution0521();
        String a = "aba", b = "cdc";
        System.out.println(obj.findLUSlength(a, b));
    }

    /**
     * 若两字符串不相同，那么我们可以选择较长的字符串作为最长特殊序列,返回其长度值
     * 特别地，当两字符串长度相同时（但不是同一字符串），我们仍然可以选择其中的一个字符串作为最长特殊序列，它不会是另一个字符串的子序列。
     * 若两字符串相同，那么任一字符串的子序列均会出现在两个字符串中，此时应返回 −1。
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
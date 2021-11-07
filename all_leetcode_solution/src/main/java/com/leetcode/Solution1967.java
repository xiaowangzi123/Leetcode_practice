package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 作为子字符串出现在单词中的字符串数目
 */
public class Solution1967 {
    public static void main(String[] args) {
        Solution1967 obj = new Solution1967();
        String[] patterns = {"a", "abc", "bc", "d"};
        System.out.println(obj.numOfStrings(patterns, "abc"));

        System.out.println("abcd".contains("cd"));
    }

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns) {
            if (word.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
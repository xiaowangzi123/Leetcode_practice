package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 检查两个字符串数组是否相等
 */
public class Solution1662 {
    public static void main(String[] args) {
        Solution1662 obj = new Solution1662();
        String[] word1 = {"a", "cb"}, word2 = {"ab", "c"};
        System.out.println(obj.arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for (String s : word1) {
            s1.append(s);
        }
        for (String s : word2) {
            s2.append(s);
        }
        return s1.equals(s2);
    }
}
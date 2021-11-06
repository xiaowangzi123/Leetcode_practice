package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 检查二进制字符串字段
 */
public class Solution1784 {
    public static void main(String[] args) {
        Solution1784 obj = new Solution1784();
        System.out.println(obj.checkOnesSegment("1001"));
        System.out.println(obj.checkOnesSegment2("1001"));
    }

    /**
     * 最多出现一次连续的1片段
     * 第一个字符为1，后续出现"01"就出现了两次连续为1的片段，返回false
     */
    public boolean checkOnesSegment(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }

    public boolean checkOnesSegment2(String s) {
        return !s.contains("01");
    }
}
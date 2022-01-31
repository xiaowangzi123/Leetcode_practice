package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2022/1/9
 * @description : 字符串轮转
 */
public class Interview0109 {
    public static void main(String[] args) {
        Interview0109 obj = new Interview0109();
        System.out.println(obj.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(obj.isFlipedString("abc", "cba"));
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }
}
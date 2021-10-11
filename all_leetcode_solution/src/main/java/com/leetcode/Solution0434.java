package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/7
 * @description : 统计单词个数
 */
public class Solution0434 {
    public static void main(String[] args) {
        Solution0434 obj = new Solution0434();
        String s = "Hello, my name is John";
        System.out.println(obj.countSegments(s));
        System.out.println(obj.countSegments2(s));
    }

    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //i==0时，第0位不为‘ ’，则是一个单词； i!=0时，第i-1位为‘ ’加第i位不为‘ ’，则是一个单词
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    public int countSegments2(String s) {
        String[] arr = s.split(" ");
        int len = arr.length;
        for (String a : arr) {
            if (a.length() == 0) {
                --len;
            }
        }
        return len;
    }


}
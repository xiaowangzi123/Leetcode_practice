package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/25
 * @description : 反转字符串 II
 */
public class Solution0541 {
    public static void main(String[] args) {
        Solution0541 obj = new Solution0541();
        String s = "abcdefg";
        System.out.println(obj.reverseStr(s,2));
    }

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i=k-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(k));
        return sb.toString();
    }
}
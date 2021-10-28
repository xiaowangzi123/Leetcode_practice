package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/29
 * @description : 比较含退格的字符串
 */
public class Solution0844 {
    public static void main(String[] args) {
        Solution0844 obj = new Solution0844();
        String s = "ab#c", t = "ad#c";
        System.out.println(obj.backspaceCompare(s, t));
        System.out.println(s.substring(0, 2));
    }

    public boolean backspaceCompare(String s, String t) {
        return getNewString(s).equals(getNewString(t));
    }

    public String getNewString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
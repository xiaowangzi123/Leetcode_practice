package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description：
 */
public class Solution0125 {
    public static void main(String[] args) {
        Solution0125 obj = new Solution0125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        System.out.println(sb);
        return sb.equals(sb.reverse());
    }
}
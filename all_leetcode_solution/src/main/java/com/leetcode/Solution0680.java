package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/26
 * @description : 验证回文字符串 Ⅱ
 */
public class Solution0680 {
    public static void main(String[] args) {
        Solution0680 obj = new Solution0680();
//        System.out.println(obj.validPalindrome("abc"));
//        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        String s = "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu";
        System.out.println(obj.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        boolean b1 = false, b2 = false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (s.charAt(i + 1) == s.charAt(j)) {
                b1 = isPalindrome(s.substring(i + 1, j));
            } else if (s.charAt(i) == s.charAt(j - 1)) {
                b2 = isPalindrome(s.substring(i, j - 1));
            } else {
                return false;
            }
        }
        return b1||b2;
    }


    //判断是否为回文字符
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
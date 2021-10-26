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
        int i = 0, j = s.length() - 1, count = 0;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (s.charAt(i + 1) == s.charAt(j)) {
                count++;
                i += 2;
                j--;
            } else if (s.charAt(i) == s.charAt(j - 1)) {
                count++;
                i++;
                j -= 2;
            } else {
                return false;
            }
        }
        return count < 2;
    }
}
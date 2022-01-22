package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/1
 * @description : 删除回文子序列
 * 只有ab组成，一次删除a,第二次删除b,最多删除两次
 * 如果字符串本身是一个回文字符串，那仅仅需要删除一次
 */
public class Solution1332 {
    public static void main(String[] args) {
        Solution1332 obj = new Solution1332();
        System.out.println(obj.removePalindromeSub("ababaa"));
        System.out.println(obj.removePalindromeSub2("ababaa"));
    }


    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public int removePalindromeSub2(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }
            i++;
            j--;
        }
        return 1;
    }
}
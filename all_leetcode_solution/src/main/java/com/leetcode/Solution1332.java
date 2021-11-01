package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/1
 * @description : 删除回文子序列
 */
public class Solution1332 {
    public static void main(String[] args) {
        Solution1332 obj = new Solution1332();
        System.out.println(obj.removePalindromeSub("ababaa"));
    }

    public int removePalindromeSub(String s) {
        if (isPalindrome(s)){
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
}
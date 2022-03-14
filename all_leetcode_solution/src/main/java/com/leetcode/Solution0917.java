package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/29
 * @description : 仅仅反转字母
 */
public class Solution0917 {
    public static void main(String[] args) {
        Solution0917 obj = new Solution0917();
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(obj.reverseOnlyLetters(s));
        System.out.println(Character.isLetter(s.charAt(0)));
    }

    public String reverseOnlyLetters(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (Character.isLetter(chs[i]) && Character.isLetter(chs[j])) {
                char temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;
                i++;
                j--;
            } else if (!Character.isLetter(chs[i])) {
                i++;
            } else if (!Character.isLetter(chs[j])) {
                j--;
            }
        }
        return new String(chs);
    }

    public String reverseOnlyLetters2(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (isLetter(chs[i]) && isLetter(chs[j])) {
                char temp = chs[i];
                chs[i] = chs[j];

                i++;
                chs[j] = temp;
                j--;
            } else if (!isLetter(chs[i])) {
                i++;
            } else if (!isLetter(chs[j])) {
                j--;
            }
        }
        return new String(chs);
    }

    public boolean isLetter(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
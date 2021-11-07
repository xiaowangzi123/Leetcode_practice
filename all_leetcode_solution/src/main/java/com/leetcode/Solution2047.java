package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description :
 */
public class Solution2047 {
    public static void main(String[] args) {
        Solution2047 obj = new Solution2047();
//        String sentence = "cat and  dog";
        String sentence = " o6 t";
        System.out.println(obj.countValidWords(sentence));
        System.out.println("---------------");

        System.out.println('!' < 'a' || '!' > 'z');
        System.out.println('c' < 'a' || 'c' > 'z');

        System.out.println("---------------");
        System.out.println(obj.isValidToken("!this"));
        System.out.println(obj.isValidToken("b8d"));
        System.out.println(obj.isValidToken("a!-s"));
    }

    public int countValidWords(String sentence) {
        int count = 0;
        String[] strs = sentence.trim().split(" +");
        for (String s : strs) {
            if (isValidToken(s)) {
                count++;
            }
        }
        return count;
    }

    public boolean isValidToken(String s) {
        int symbol = 0, mark = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                return false;
            } else if (s.charAt(i) == '-') {
                symbol++;
                if (symbol > 1 || i == 0 || i == s.length() - 1 || (s.charAt(i - 1) < 'a' || s.charAt(i - 1) > 'z') || (s.charAt(i + 1) < 'a' || s.charAt(i + 1) > 'z')) {
                    return false;
                }
            } else if (s.charAt(i) == '!' || s.charAt(i) == '.' || s.charAt(i) == ',') {
                mark++;
                if (mark > 1 || i != s.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
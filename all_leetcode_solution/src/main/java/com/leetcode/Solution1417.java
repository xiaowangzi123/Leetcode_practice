package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/2
 * @description : 重新格式化字符串
 */
public class Solution1417 {
    public static void main(String[] args) {
        Solution1417 obj = new Solution1417();
        System.out.println(obj.reformat("a0b1c2"));
    }

    public String reformat(String s) {
        int digit = 0, letter = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letter++;
            } else {
                digit++;
            }
        }
        if (Math.abs(digit - letter) > 1) {
            return "";
        }

        digit = (digit >= letter) ? 0 : 1;
        letter = (digit == 0) ? 1 : 0;

        char[] ans = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                ans[letter]=ch;
                letter+=2;
            }else {
                ans[digit]=ch;
                digit+=2;
            }
        }
        return new String(ans);
    }
}
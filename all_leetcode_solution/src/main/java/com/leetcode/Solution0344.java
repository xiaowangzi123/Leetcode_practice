package com.leetcode;


import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/2/5
 * @description: 反转字符串
 */
public class Solution0344 {
    public static void main(String[] args) {
        Solution0344 obj = new Solution0344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        obj.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public void reverseString2(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            char temp = chs[i];
            chs[i] = chs[chs.length - i - 1];
            chs[chs.length - i - 1] = temp;
        }
    }

}
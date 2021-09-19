package com.leetcode;

import java.io.Console;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0459 {
    public static void main(String[] args) {
        Solution0459 obj = new Solution0459();
        String s = "abcabc";
        System.out.println(obj.repeatedSubstringPattern2(s));

        String s2 = "bb";
        System.out.println(obj.repeatedSubstringPattern2(s2));

        String s3 = "ababba";
        System.out.println(obj.repeatedSubstringPattern2(s3));


    }

    //错误思路，理解错了题目
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        int a = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                a = count[i];
                break;
            }
        }
        for (int i : count) {
            if (i != 0) {
                if (i != a) {
                    return false;
                }
            }
        }
        return true;
    }

    //
    public boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        String temp = str.substring(1, str.length() - 1);
        return temp.contains(s);
    }

    public boolean repeateSubstringpattern3(String){

    }


}
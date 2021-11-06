package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description :
 */
public class Solution1704 {
    public static void main(String[] args) {
        Solution1704 obj = new Solution1704();
        System.out.println(obj.halvesAreAlike("book"));
    }

    public boolean halvesAreAlike(String s) {
//        Set<Character> set = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        int a = 0, b = 0;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (isVowel(s.charAt(i))) {
                a++;
            }
            if (isVowel(s.charAt(j))) {
                b++;
            }
            i++;
            j--;
        }
        return a == b;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
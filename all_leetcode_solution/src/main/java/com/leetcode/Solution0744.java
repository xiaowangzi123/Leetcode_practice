package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0744 {
    public static void main(String[] args) {
        Solution0744 obj = new Solution0744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        System.out.println(obj.nextGreatestLetter(letters, target));

        System.out.println(target == letters[0]);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (target == letters[i] && i != letters.length - 1) {
                return letters[i+1];
            }
        }

        return letters[0];
    }
}
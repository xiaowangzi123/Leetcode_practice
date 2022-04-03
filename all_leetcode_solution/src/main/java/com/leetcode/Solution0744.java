package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :寻找比目标字母大的最小字母
 */
public class Solution0744 {
    public static void main(String[] args) {
        Solution0744 obj = new Solution0744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';
        System.out.println(obj.nextGreatestLetter(letters, target));

        System.out.println(target > letters[0]);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                return letters[i];
            }
        }
        return letters[0];
    }
}
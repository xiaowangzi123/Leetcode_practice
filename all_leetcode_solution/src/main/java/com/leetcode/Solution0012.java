package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 整数转罗马数字
 */
public class Solution0012 {
    public static void main(String[] args) {
        Solution0012 obj = new Solution0012();
        System.out.println(obj.intToRoman(3));
        System.out.println(obj.intToRoman(9));
        System.out.println(obj.intToRoman(58));
        System.out.println(obj.intToRoman(140));
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num > 0 && num >= values[i]) {
                ans.append(symbols[i]);
                num -= values[i];
            }
        }
        return ans.toString();
    }
}
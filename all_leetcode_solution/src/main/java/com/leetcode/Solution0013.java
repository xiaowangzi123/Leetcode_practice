package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 罗马数字转整数
 */
public class Solution0013 {
    public static void main(String[] args) {
        Solution0013 obj = new Solution0013();
//        System.out.println(obj.romanToInt("III"));
//        System.out.println(obj.romanToInt("IV"));
//        System.out.println(obj.romanToInt("IX"));
        System.out.println(obj.romanToInt("LVIII"));
        System.out.println(obj.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int sum = 0, base = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int temp = getValue(s.charAt(i));
            if (base < temp) {
                sum -= base;
            } else {
                sum += base;
            }
            base = temp;
        }
        sum += base;
        return sum;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
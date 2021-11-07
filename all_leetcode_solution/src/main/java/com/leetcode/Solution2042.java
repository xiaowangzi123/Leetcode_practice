package com.leetcode;

import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 检查句子中的数字是否递增
 */
public class Solution2042 {
    public static void main(String[] args) {
        Solution2042 obj = new Solution2042();
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        System.out.println(obj.areNumbersAscending(s));
        System.out.println(obj.areNumbersAscending2(s));
    }

    //遍历
    public boolean areNumbersAscending(String s) {
        int i = 0, n = s.length(), max = Integer.MIN_VALUE;
        while (i < n) {
            if (!Character.isDigit(s.charAt(i))) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < n && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i));
                    i++;
                }
                int temp = Integer.valueOf(sb.toString());
                if (temp > max) {
                    max = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean areNumbersAscending2(String s) {
        int max = Integer.MIN_VALUE;
        String[] st = s.split(" ");
        for (String str : st) {
            if ('0' <= str.charAt(0) && str.charAt(0) <= '9') {
                int temp = Integer.valueOf(str);
                if (temp > max) {
                    max = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
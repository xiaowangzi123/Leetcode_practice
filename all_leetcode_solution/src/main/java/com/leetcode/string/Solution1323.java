package com.leetcode.string;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1323 {

    public static void main(String[] args) {
        Solution1323 obj = new Solution1323();
        int num = 9669;
        System.out.println(obj.maximum69Number(num));
    }


    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '6') {
                ch[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }


}
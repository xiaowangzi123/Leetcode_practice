package com.leetcode;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0806 {
    public static void main(String[] args) {
        Solution0806 obj = new Solution0806();
//        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
//        String s = "abcdefghijklmnopqrstuvwxyz";

        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        System.out.println(Arrays.toString(obj.numberOfLines(widths, s)));

        System.out.println(Math.ceil(2.1));
    }

    public int[] numberOfLines(int[] widths, String s) {
        int len = 0;
        for (char ch : s.toCharArray()) {
            int cnt = widths[ch - 'a'];
            len += cnt;
        }
        return new int[]{(int) Math.ceil((double) len / 100), len % 100};
    }
}
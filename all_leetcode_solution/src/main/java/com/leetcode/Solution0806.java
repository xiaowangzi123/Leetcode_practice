package com.leetcode;


import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description : 806. 写字符串需要的行数
 */
public class Solution0806 {
    public static void main(String[] args) {
        Solution0806 obj = new Solution0806();
//        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
//        String s = "abcdefghijklmnopqrstuvwxyz";

        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        System.out.println(Arrays.toString(obj.numberOfLines2(widths, s)));

    }

    //不满100时，下一字符放不下时，会放在下一行
    public int[] numberOfLines(int[] widths, String s) {
        int len = 0;
        for (char ch : s.toCharArray()) {
            int cnt = widths[ch - 'a'];
            len += cnt;
        }
        return new int[]{(int) Math.ceil((double) len / 100), len % 100};
    }

    public int[] numberOfLines2(int[] widths, String s) {
        int line = 1, length = 0;
        for (char ch : s.toCharArray()) {
            int count = widths[ch - 'a'];
            length += count;
            if (length > 100) {
                line++;
                length = count;
            }
        }
        return new int[]{line, length};
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 转换字符串的最少操作次数
 */
public class Solution2027 {
    public static void main(String[] args) {
        Solution2027 obj = new Solution2027();
        System.out.println(obj.minimumMoves("XXX"));
        System.out.println(obj.minimumMoves("XXOX"));
        System.out.println(obj.minimumMoves("OOOO"));
    }

    public int minimumMoves(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 2;
            }
        }
        return count;
    }
}
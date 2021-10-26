package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/26
 * @description : 机器人能否返回原点
 */
public class Solution0657 {
    public static void main(String[] args) {
        Solution0657 obj = new Solution0657();
        System.out.println(obj.judgeCircle("UD"));
    }


    public boolean judgeCircle(String moves) {
        int i = 0, j = 0;
        for (char ch : moves.toCharArray()) {
            if ('U' == ch) {
                j++;
            } else if ('D' == ch) {
                j--;
            } else if ('R' == ch) {
                i++;
            } else {
                i--;
            }
        }

        return i==0 && j==0;
    }
}
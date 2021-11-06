package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 判断国际象棋棋盘中一个格子的颜色
 */
public class Solution1812 {
    public static void main(String[] args) {
        Solution1812 obj = new Solution1812();
        System.out.println(obj.squareIsWhite("a1"));
        System.out.println(obj.squareIsWhite2("b1"));
        System.out.println("------------------");
        System.out.println(obj.squareIsWhite("h3"));
        System.out.println(obj.squareIsWhite("c7"));
    }


    /**
     * 如果abcd列转为1234列
     * 那么每一行和每一列除以2余数为1时，格子是黑色的
     */
    public boolean squareIsWhite(String coordinates) {
        int i = coordinates.charAt(0) - 'a';
        int j = coordinates.charAt(1) - '0';
        return i % 2 == j % 2;
    }

    public boolean squareIsWhite2(String coordinates) {
        int i = coordinates.charAt(0) - 'a' + 1;
        int j = coordinates.charAt(1) - '0';
        return i % 2 != j % 2;
    }
}
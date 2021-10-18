package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 数字的补数
 */
public class Solution0476 {
    public static void main(String[] args) {
        Solution0476 obj = new Solution0476();
        System.out.println(obj.findComplement(5));

        //二进制1的个数
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.parseInt("101", 2));
        System.out.println("-----------------");
        char[] chs = {'1', '0', '1'};
        System.out.println(chs);
        System.out.println(Integer.parseInt(String.valueOf(chs), 2));

    }

    public int findComplement(int num) {
        String temp = Integer.toBinaryString(num);
        char[] ch = temp.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ch[i] ^= 1;
        }
        return Integer.parseInt(String.valueOf(ch), 2);
    }

    public int findComplement2(int num) {
        int answer = 0;

        for (int i = 0; num != 0; i++, num >>>= 1) {
            if ((num & 1) == 0) {
                answer += 1 << i;
            }
        }

        return answer;
    }
}
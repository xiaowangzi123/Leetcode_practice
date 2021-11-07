package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 哪种连续子字符串更长
 */
public class Solution1869 {
    public static void main(String[] args) {
        Solution1869 obj = new Solution1869();
//        System.out.println(obj.checkZeroOnes("1101"));
        System.out.println(obj.checkZeroOnes("01111110"));
    }

    public boolean checkZeroOnes(String s) {
        int zero = 0, one = 0;
        int zMax = Integer.MIN_VALUE, oMax = Integer.MIN_VALUE;
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '0') {
                zero++;
                zMax = Math.max(zMax, zero);
                one = 0;
            } else {
                one++;
                oMax = Math.max(oMax, one);
                zero = 0;
            }
            i++;
        }
        return oMax > zMax;
    }
}
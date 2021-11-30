package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/30
 * @description : 第N位数字
 */
public class Solution0400 {
    public static void main(String[] args) {
        Solution0400 obj = new Solution0400();
        System.out.println(obj.findNthDigit(15));
        System.out.println(obj.findNthDigit2(15));
        System.out.println(obj.findNthDigit2(10));
    }

    /**
     * x位数目有9*10^(x-1),所有x位个位数之和为x*9*10^(x-1)
     * d：当前位数个数
     * count：所有x位个位数之和
     */
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }


    public int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int num = (int) Math.pow(10, d - 1) + (n - 1) / d;
        int digitIndex = (n - 1) % d;
        char[] ch = String.valueOf(num).toCharArray();
        return ch[digitIndex] - '0';
    }

}
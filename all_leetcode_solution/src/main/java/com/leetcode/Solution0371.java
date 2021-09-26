package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/23
 * @description：
 */
public class Solution0371 {
    public static void main(String[] args) {
        Solution0371 obj = new Solution0371();
        System.out.println(obj.getSum(2, 7));
        System.out.println(obj.getSum(3, 4));
        System.out.println(obj.getSum2(3, 4));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int getSum2(int a, int b) {
        while(b!=0){
            int c=a^b;
            int d=(a&b)<<1;

            a=c;
            b=d;
        }
        return a;
    }

    public int getSum3(int a, int b) {
        while(b!=0){
            int c=a^b;
            b=(a&b)<<1;
            a=c;
        }
        return a;
    }
}
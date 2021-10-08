package com.leetcode.bitoperation;

/**
 * @author :wyq
 * @date ：Created in 2021/10/8
 * @description :
 */
public class Solution0190 {
    public static void main(String[] args) {
        Solution0190 obj = new Solution0190();

//        long n = 00000010100101000001111010011100L;
//        System.out.println(obj.anserseBits(00000010100101000001111010011100L));
        String s = "00000010100101000001111010011100";
//        System.out.println(Integer.reverseBytes(Integer.parseInt(s)));
        System.out.println(Integer.toBinaryString(25));
        System.out.println(Integer.toString(25, 2));
        System.out.println(Integer.toString(25, 8));
        System.out.println(Integer.toString(25, 10));
        System.out.println(Integer.toString(25, 16));
        System.out.println("----------------------");
//        System.out.println(Integer.reverse(Integer.parseInt(s)));
//        System.out.println(obj.reverseBits(Integer.parseInt(s)));
//        System.out.println(obj.anserseBits(Integer.valueOf(s)));


        System.out.println(obj.reverseBits(100));
        System.out.println(obj.reverseBits2(100));
        System.out.println(obj.reverseBits3(100));
    }

    /**
     * Java中，没有无符号整数类型，因此对n的右移操作应使用逻辑右移。
     * you need treat n as an unsigned value
     */
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            // n&1的结果和n的最后一位相同，等于是取出了n的最后一位，再把这一位左移31-i位就移到了翻转之后对称的位置
            ans |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n = n >> 1;
            res = (res << 1) ^ bit;
        }
        return res;
    }

    //Integer.reverse()方法源码
    public static int reverseBits3(int i) {
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
                ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }
}
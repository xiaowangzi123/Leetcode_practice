package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/2
 * @description :
 */
public class Solution0405 {
    public static void main(String[] args) {
        Solution0405 obj = new Solution0405();
        System.out.println(obj.toHex(1));
        System.out.println(Integer.toHexString(1));

        System.out.println(obj.toHex(-1));
        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(-18));
        long l = 111 << 32;
        System.out.println(-1 + l);

    }

    public String toHex(int num) {
        String s = "0123456789abcdef";
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (num != 0 && res.length() < 8) {
            res.append(s.charAt((num & 0xf)));
            num >>= 4;
        }
        return res.reverse().toString();

    }

    public String toHex2(int num) {
        String s = "0123456789abcdef";
        if (num == 0) {
            return "0";
        }

//        long n = num > 0 ? num : num + (111 << 32);

        StringBuilder res = new StringBuilder();
        while (num != 0 && res.length() < 8) {
            // 进制转换
//            res = s.charAt((int) (n % 16)) + res;
            res.append(s.charAt((num & 0xf)));
            num >>= 4;
        }
        return res.reverse().toString();

    }
}
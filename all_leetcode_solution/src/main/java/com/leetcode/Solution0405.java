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
        System.out.println(obj.toHex2(1));
        System.out.println(Integer.toHexString(1));
        System.out.println("-----------------");

        System.out.println(obj.toHex(-1));
        System.out.println(obj.toHex2(-1));
        System.out.println(Integer.toHexString(-1));
        System.out.println("-----------------");

        System.out.println(Integer.toHexString(-18));

        System.out.println(0 & 0xf);
        System.out.println(-1 & 0xf);
        System.out.println(1 & 0xf);
        System.out.println(2 & 0xf);
        System.out.println(33 & 0xf);
        System.out.println(46 & 0xf);
        System.out.println(25 & 0xf);

        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(0xf));

    }

    public String toHex(int num) {
        String s = "0123456789abcdef";
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        //位移运算并不能保证num==0，需要使用32位int保证（对应16进制小于等于8位
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

        String res = "";
        /*while (num != 0 && res.length() < 8) {
            // 不能取余操作，负数时报错String index out of range
            res.append(s.charAt((num % 16)));
            num /= 16;
        }*/
        while (num != 0 && res.length() < 8) {
            res += s.charAt(num & 0xf);
            num /= 4;
        }
        return res;

    }
}
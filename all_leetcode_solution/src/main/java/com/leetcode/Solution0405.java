package com.leetcode;

import static java.lang.Integer.parseInt;

/**
 * @author :wyq
 * @date ：Created in 2021/10/2
 * @description : 十六进制
 * 所以对于正数，可以随意使用位移，与乘除几乎没有结果的区别
 * 反码跟原码是正数时，一样；负数时，反码就是原码符号位除外，其他位按位取反。
 * 正整数的补码是其二进制表示，与原码相同；
 * 负整数的补码，将其原码除符号位外的所有位取反（0变1，1变0，符号位为1不变）后加1
 * 负数以补码的形式存在
 * 而对于负数来说，Java中的位移应该谨慎使用，因为位移运算在Java中称为带符号的位移
 * -5<<1，我们以int为例，由于负数在内存是以补码存在
 * -5二进制原码：1000 0000 0000 0000 0000 0000 0000 0101
 *        反码：1111 1111 1111 1111 1111 1111 1111 1010
 *        补码：1111 1111 1111 1111 1111 1111 1111 1011
 * 向左移1位即结果为：1111 1111 1111 1111 1111 1111 1111 0110 (后位补0)
 * 将结果计算反码为：1111 1111 1111 1111 1111 1111 1111 0101
 * 将结果计算原码为：1000 0000 0000 0000 0000 0000 0000 1010
 * 所以结果为：数字-10
 */
public class Solution0405 {
    public static void main(String[] args) {
        Solution0405 obj = new Solution0405();
        System.out.println(obj.toHex(26));
        System.out.println(obj.toHex2(26));
        System.out.println(Integer.toHexString(26));
        System.out.println("-----------------");

        System.out.println(obj.toHex(-1));
        System.out.println(obj.toHex2(-1));
        System.out.println(Integer.toHexString(-1));
        System.out.println("-----------------");

        System.out.println(obj.toHex(-26));
        System.out.println(obj.toHex2(-26));
        System.out.println(Integer.toHexString(-26));
        System.out.println("-----------------");

        System.out.println(Integer.toHexString(-18));

        System.out.println(0 & 0xf);
        System.out.println(-1 & 0xf);
        System.out.println(1 & 0xf);
        System.out.println(2 & 0xf);
        System.out.println(33 & 0xf);
        System.out.println(46 & 0xf);
        System.out.println(25 & 0xf);

        System.out.println("---------------------------");
        //转为二进制
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(0xf));
        System.out.println("---------------------------");

        System.out.println("---------右移动和除以结果不一致------------------");
        System.out.println(26/16);
        System.out.println(26>>4);
        System.out.println(-26/16);
        System.out.println(-26>>4);

        System.out.println("-------------二进制--------------");
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(-5));

        System.out.println(Integer.toBinaryString(5/2));
        System.out.println(Integer.toBinaryString(5>>1));

        System.out.println(-5/2);
        System.out.println(-5>>1);
        /**
         * 补码：1111 1111 1111 1111 1111 1111 1111 1110
         * 反码：1111 1111 1111 1111 1111 1111 1111 1101
         * 原码：1000 0000 0000 0000 0000 0000 0000 0010
         * 结果为-2
         */
        System.out.println(Integer.toBinaryString(-5/2));
        /**
         * 补码：1111 1111 1111 1111 1111 1111 1111 1101
         * 反码：1111 1111 1111 1111 1111 1111 1111 1100
         * 原码：1000 0000 0000 0000 0000 0000 0000 0011
         * 结果为-3
         */
        System.out.println(Integer.toBinaryString(-5>>1));


        /**
         *    5原码：0000 0000 0000 0000 0000 0000 0000 0101
         * 左移两位：0000 0000 0000 0000 0000 0000 0001 0100
         * 结果为10，相当于乘以2，但并不代表两者是一样的
         * 5左移29位，变为负数-1610612736，其二进制表示如下：
         *          1010 0000 0000 0000 0000 0000 0000 0000
         * 左移超过32位时，对移动位数32取余，即左移34位和左移两位结果一致
         */
        System.out.println("----------左移 >>----------");
        System.out.println(Integer.toBinaryString(5<<2));
        System.out.println(Integer.toBinaryString(5<<34));
        System.out.println(Integer.toBinaryString(5<<29));
        System.out.println(5<<29);

        System.out.println("----------右移运算符 >>----------");
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

    //执行速度比方法一慢
    public String toHex2(int num) {
        String s = "0123456789abcdef";
        if (num == 0) {
            return "0";
        }
        String res = "";
        /*while (num != 0 && res.length() < 8) {
            // 不能取余操作，负数时报错String index out of range
            res.append(s.charAt((num % 16)));
            // 取整和位移操作，负数时结果不一致
            num /= 16;
        }*/
        while (num != 0 && res.length() < 8) {
            res = s.charAt(num & 0xf) + res;
            num >>= 4;
        }
        return res;

    }
}
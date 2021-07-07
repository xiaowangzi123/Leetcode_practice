package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0067 {
    public static void main(String[] args) {
        Solution0067 obj = new Solution0067();
        String a = "1010", b = "1011";
        System.out.println(obj.addBinary(a, b));
        System.out.println(obj.addBinary2(a, b));
    }

    /**
     * 如果字符串超过 3333 位，不能转化为 Integer
     * 如果字符串超过 6565 位，不能转化为 Long
     * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
     *
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }



    /**
     * 整体思路是将两个字符串较短的用 00补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果。
     * 由于字符串操作原因，不确定最后的结果是否会多出一位进位，所以会有 2 种处理方式：
     *
     * 第一种，在进行计算时直接拼接字符串，会得到一个反向字符，需要最后再进行翻转
     * 第二种，按照位置给结果字符赋值，最后如果有进位，则在前方进行字符串拼接添加进位
     *
     */
    public String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(sum % 2);
            ca = sum / 2;
        }
        res.append(ca == 1 ? ca : "");
        return res.reverse().toString();
    }


}
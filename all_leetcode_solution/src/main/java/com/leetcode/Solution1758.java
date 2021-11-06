package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 生成交替二进制字符串的最少操作数
 */
public class Solution1758 {
    public static void main(String[] args) {
        Solution1758 obj = new Solution1758();
        System.out.println(obj.minOperations("0100"));
        System.out.println("0100".charAt(1) % 2 == 1);
    }

    /**
     * 偶数位放0，奇数位放1，统计需要变化次数
     * 偶数位放1，奇数位放0，统计需要变化次数
     * 去两者之间的最小值
     */
    public int minOperations(String s) {
        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == i % 2) {
                a++;
            }else {
                b++;
            }
        }
        return Math.min(a, b);
    }
}
package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/2/5
 * @description: 面试题 08.01. 三步问题
 */
public class Interview0801 {
    public static void main(String[] args) {
        Interview0801 obj = new Interview0801();
        System.out.println(obj.waysToStep(3));
        System.out.println(obj.waysToStep(10));
    }

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] d = new int[n + 1];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007 + d[i - 3];
            d[i] %= 1000000007;
        }
        return d[n];
    }

}
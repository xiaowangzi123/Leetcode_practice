package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0441 {
    public static void main(String[] args) {
        Solution0441 obj = new Solution0441();

        System.out.println(obj.arrangeCoins(1));
        System.out.println(obj.arrangeCoins2(1));
        System.out.println(obj.arrangeCoins(5));
        System.out.println(obj.arrangeCoins2(5));
        System.out.println(obj.arrangeCoins(6));
        System.out.println(obj.arrangeCoins2(6));
        System.out.println(obj.arrangeCoins(8));
        System.out.println(obj.arrangeCoins2(8));


        System.out.println(obj.arrangeCoins(1804289383));
        System.out.println(obj.arrangeCoins2(1804289383));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE/2);
    }

    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

    public int arrangeCoins2(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = (r - l + 1) / 2 + l;
            if (m * (m + 1) <= (n * 2)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
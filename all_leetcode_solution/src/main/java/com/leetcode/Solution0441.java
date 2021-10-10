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

        System.out.println("--------------------");
        System.out.println(obj.arrangeCoins(1804289383));
        System.out.println(obj.arrangeCoins2(1804289383));
        System.out.println(obj.arrangeCoins3(1804289383));
        System.out.println("---------------------");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE / 2);

        //加不加括号值不一样
        System.out.println((long) (1804289383 * 2));
        System.out.println((long) 1804289383 * 2);
    }

    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

    //int不够大，导出错误
    public int arrangeCoins2(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = (r - l + 1) / 2 + l;
            if ((long) m * (m + 1) <= (long) n * 2) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public int arrangeCoins3(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
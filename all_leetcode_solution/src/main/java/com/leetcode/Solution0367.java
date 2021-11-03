package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/4
 * @description : 有效的完全平方数
 */
public class Solution0367 {
    public static void main(String[] args) {
        Solution0367 obj = new Solution0367();
        System.out.println(obj.isPerfectSquare(1));
        System.out.println(obj.isPerfectSquare(16));
        System.out.println("---------------");
        System.out.println(obj.isPerfectSquare(2147483647));
        System.out.println(obj.isPerfectSquare2(2147483647));
        System.out.println(obj.isPerfectSquare3(2147483647));
    }

    /**
     * i*i<=num超时
     * 2147483647
     */
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i <= Math.sqrt(num); i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    public boolean isPerfectSquare3(int num) {
        int l = 0, r = num;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid <= num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
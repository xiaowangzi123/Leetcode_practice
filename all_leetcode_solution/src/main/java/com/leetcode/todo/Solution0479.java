package com.leetcode.todo;

/**
 * @author :wyq
 * @date ：Created in 2022/4/16
 * @description : TODO
 * 479. 最大回文数乘积
 */
public class Solution0479 {
    public static void main(String[] args) {
        Solution0479 obj = new Solution0479();
        System.out.println(obj.largestPalindrome(1));
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) {
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) {
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
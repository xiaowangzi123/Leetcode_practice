package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0007 {
    public static void main(String[] args) {
        Solution0007 obj = new Solution0007();
        int target = 79;
        System.out.println(obj.reverse(target));
        System.out.println(obj.reverse(120));
        System.out.println(obj.reverse(1201));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        return res;
    }


}
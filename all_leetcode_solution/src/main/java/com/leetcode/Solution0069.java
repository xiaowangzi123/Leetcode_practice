package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0069 {
    public static void main(String[] args) {
        Solution0069 obj = new Solution0069();
        System.out.println(obj.mySqrt(9));
        System.out.println(obj.mySqrt2(9));
        System.out.println(obj.mySqrt3(9));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;

    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int l = 1, r = x / 2;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public int mySqrt3(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


}
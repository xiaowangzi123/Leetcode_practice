package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0793 {
    public static void main(String[] args) {
        Solution0793 obj = new Solution0793();
        System.out.println(obj.preimageSizeFZF(5));
    }

    public int preimageSizeFZF(int K) {
        long left = 0, right = 5L * (K + 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = numOfTrailingZeros(mid);
            if (count == K) return 5;
            else if (count < K) left = mid + 1;
            else right = mid;
        }
        return 0;
    }

    public long numOfTrailingZeros(long x) {
        long res = 0;
        for (; x > 0; x /= 5) {
            res += x / 5;
        }
        return res;
    }


}
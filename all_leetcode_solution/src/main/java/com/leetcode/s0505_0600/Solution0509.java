package com.leetcode.s0505_0600;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数
 */
public class Solution0509 {
    public static void main(String[] args) {
        Solution0509 solution = new Solution0509();
        System.out.println(System.currentTimeMillis());
        System.out.println(solution.fib(1000));
        System.out.println(System.currentTimeMillis());
        System.out.println(solution.fib2(1000));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 递归,计算次数随着N的增加，指数级增长，不合适
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private final Map<Integer, Integer> memo = new HashMap<>();

    public int fib2(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;
        if (n < 2) {
            result = n;
        } else {
            result = fib2(n - 1) + fib2(n - 2);
        }

        memo.put(n, result);
        return result;
    }


}

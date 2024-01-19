package com.leetcode.s0001_0100;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 */
public class Solution0070 {
    public static void main(String[] args) {
        Solution0070 obj = new Solution0070();
        System.out.println(obj.climbStairs(1));
        System.out.println(obj.climbStairs(2));
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
        System.out.println(obj.climbStairs(5));
        System.out.println(obj.climbStairs2(5));
    }

    /**
     * 递归(超时)
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     * f(n)是所求结果
     * 设初始值，f(0)=f(1)=1，都只有一种方式
     * n个台阶时，第一步可以爬一个或两个台阶，爬一个台阶后，有f(n-1)种方式，怕两个台阶后有f(n-2)种方式
     * f(n)=f(n-1)+f(n-2)
     */
    public int climbStairs2(int n) {
        int[] nums = new int[n + 1];
        nums[0] = nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    private final Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 记忆化搜索
     */
    public int climbStairs3(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;
        if (n < 2) {
            result = 1;
        } else {
            result = climbStairs3(n - 1) + climbStairs3(n - 2);
        }

        memo.put(n, result);
        return result;
    }

}
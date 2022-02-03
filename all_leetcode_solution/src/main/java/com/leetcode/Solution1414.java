package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/2/3
 * @description: 和为 K 的最少斐波那契数字数目
 */
public class Solution1414 {
    public static void main(String[] args) {
        Solution1414 obj = new Solution1414();
        System.out.println(obj.findMinFibonacciNumbers2(5));
        System.out.println(obj.findMinFibonacciNumbers2(7));
        System.out.println(obj.findMinFibonacciNumbers(10));
        System.out.println(obj.findMinFibonacciNumbers(19));
    }

    //超时
    public int findMinFibonacciNumbers(int k) {
        int n = 1;
        while (getFibonacci(n) < k) {
            n++;
        }
        int ans = 0;
        for (int i = n; i >= 0; i--) {
            int temp = getFibonacci(i);
            if (k >= temp) {
                k -= temp;
                ans++;
                if (k == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public int getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }


    public int findMinFibonacciNumbers2(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int f1 = 1, f2 = 1;
        while (f1 + f2 <= k) {
            int temp = f1 + f2;
            list.add(temp);
            f1 = f2;
            f2 = temp;
        }
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int temp = list.get(i);
            if (k >= temp) {
                k -= temp;
                ans++;
                if (k == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
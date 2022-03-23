package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/3/23
 * @description: TODO
 * 字典序的第K小数字
 */
public class Solution0440 {
    public static void main(String[] args) {
        Solution0440 obj = new Solution0440();
        System.out.println(obj.findKthNumber(13,2));

    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    /**
     *
     */
    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
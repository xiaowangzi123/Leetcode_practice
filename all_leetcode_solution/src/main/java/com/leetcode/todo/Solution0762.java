package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/4/5
 * @description: TODO
 * 二进制表示中质数个计算置位
 */
public class Solution0762 {
    public static void main(String[] args) {
        Solution0762 obj = new Solution0762();
        System.out.println(obj.countPrimeSetBits(1, 22));
        System.out.println(obj.countPrimeSetBits(47, 85));
    }


    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 判断是否是质数
     */
    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
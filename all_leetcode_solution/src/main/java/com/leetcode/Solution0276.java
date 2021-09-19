package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0276 {
    public static void main(String[] args) {
        Solution0276 obj = new Solution0276();
        System.out.println(obj.minSteps(2));
        System.out.println(obj.minSteps2(8));
        System.out.println(obj.minSteps2(9));
    }

    //本质是因式分解
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    /**
     * 求n 的因数；
     * 假设一个因数为 i，另一个为 j 那么答案就是 ans = [n = i]时的次数 + j 遍历他的因数，求最小值就行。
     * 因数又由因数，所以直接递归就好，边界值就是 n==1;
     */
    public int minSteps2(int n) {
        if (n == 1) return 0;
        for (int i = n / 2; i > 2; --i) {
            if (n % i == 0) {
                return minSteps2(i) + n / i;
            }
        }
        return n;
    }

}
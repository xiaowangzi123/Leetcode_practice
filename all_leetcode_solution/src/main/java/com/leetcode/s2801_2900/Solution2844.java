package com.leetcode.s2801_2900;

import java.util.Arrays;

/**
 * 生成特殊数字的最少操作
 * https://blog.csdn.net/qq_42958831/article/details/132664762
 */
public class Solution2844 {
    public static void main(String[] args) {

    }

    /**
     * TODO
     * <p>
     * 1. 转换 设 cnt 为满足 nums[i] % m == k 的索引 i 的数量
     * 如果 nums[i] % m == k，则 nums[i] = 1，否则 nums[i] = 0
     * ==> cnt = 子数组的元素和   ==> 前缀和
     * <p>
     * 2. 取模 cnt % modulo == k  ==> (pre[r] - pre[l]) % m = k
     * ==> (pre[r] % m - pre[l] % m + m) % m = k
     * 3. 式子变形 (pre[r] % m - pre[l] % m + m) % m = k
     * (pre[r] - k + m) % m = pre[l]
     * 用哈希表记录pre[l]出现的次数  => 两数之和
     */
    String num;
    int[][] cache;

    public int minimumOperations(String num) {
        this.num = num;
        int n = num.length();
        cache = new int[n][25];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, 0);
    }

    // 定义dfs(i, last) 表示 枚举到第i位，0-i位上被25整除后的余数为last，要操作的次数
    // 枚举第i位删还是不删
    public int dfs(int i, int last) {
        if (i == num.length()) {
            return last == 0 ? 0 : num.length();
        }
        if (cache[i][last] >= 0) {
            return cache[i][last];
        }
        int res = num.length();
        res = Math.min(res, dfs(i + 1, (last * 10 + (num.charAt(i) - '0')) % 25));
        res = Math.min(res, dfs(i + 1, last) + 1);
        return cache[i][last] = res;
    }
}

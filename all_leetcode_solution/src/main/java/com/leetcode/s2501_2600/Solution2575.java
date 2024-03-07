package com.leetcode.s2501_2600;

import java.util.Arrays;

/**
 * 找出字符串的可整除数组
 * TODO
 */
public class Solution2575 {
    public static void main(String[] args) {
        Solution2575 solution = new Solution2575();

        //[1,1,0,0,0,1,1,0,0]
        System.out.println(Arrays.toString(solution.divisibilityArray("998244353", 3)));
        //[0,1,0,1]
        System.out.println(Arrays.toString(solution.divisibilityArray("1010", 10)));
    }

    /**
     * 一个整数可表示为 a*10+b
     * (a*10+b) mod m = (a mod m * 10 + b) mod m
     *
     *
     * 也就是初始化r[0] = word[0] % m，
     * 然后对于所有的i > 0都有r[i] = (r[i - 1] * 10 + word[i]) % m
     * 计算出每一位对m取模的结果并根据模是否为0填充答案数组了。
     */
    public int[] divisibilityArray(String word, int m) {
        long now = 0;
        int[] res = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //now值每次都
            now = (now * 10 + Character.getNumericValue(c)) % m;
            res[i] = (now == 0) ? 1 : 0;
        }

        return res;
    }
}

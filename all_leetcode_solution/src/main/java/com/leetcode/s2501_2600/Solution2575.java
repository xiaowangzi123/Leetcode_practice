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

    public int[] divisibilityArray(String word, int m) {
        long now = 0;
        int[] res = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            now = (now * 10 + Character.getNumericValue(c)) % m;
            res[i] = (now == 0) ? 1 : 0;
        }

        return res;
    }
}

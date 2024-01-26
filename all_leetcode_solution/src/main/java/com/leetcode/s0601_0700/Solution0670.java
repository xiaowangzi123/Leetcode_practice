package com.leetcode.s0601_0700;

/**
 * 最大交换
 */
public class Solution0670 {
    public static void main(String[] args) {
        Solution0670 solution = new Solution0670();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
    }


    public int maximumSwap(int num) {
        int max = num;
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                max = Math.max(max, swap(num, i, j));
            }
        }
        return max;
    }

    public int swap(int num, int i, int j) {
        char[] chars = String.valueOf(num).toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return Integer.parseInt(new String(chars));
    }
}

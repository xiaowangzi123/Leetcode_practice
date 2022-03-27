package com.leetcode.todo;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/3/20
 * @description : 2028. 找出缺失的观测数据
 * TODO
 */
public class Solution2028 {
    public static void main(String[] args) {
        Solution2028 obj = new Solution2028();
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int missingSum = mean * (n + m);
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        int quotient = missingSum / n;
        int remainder = missingSum % n;
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            missing[i] = quotient + ((i < remainder) ? 1 : 0);
        }
        return missing;
    }

}
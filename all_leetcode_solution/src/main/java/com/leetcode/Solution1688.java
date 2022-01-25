package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/1/25
 * @description: 比赛中的配对次数
 */
public class Solution1688 {
    public static void main(String[] args) {
        Solution1688 obj = new Solution1688();
        System.out.println(obj.numberOfMatches(7));
        System.out.println(obj.numberOfMatches2(7));
    }

    public int numberOfMatches(int n) {
        return n - 1;
    }

    public int numberOfMatches2(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                ans += n / 2;
                n /= 2;
            } else {
                ans += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return ans;
    }
}
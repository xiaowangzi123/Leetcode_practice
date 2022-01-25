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
    }

    public int numberOfMatches(int n) {
        return n-1;
    }
}
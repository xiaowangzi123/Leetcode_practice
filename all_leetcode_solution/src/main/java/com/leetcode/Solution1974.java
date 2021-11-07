package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 使用特殊打字机键入单词的最少时间
 */
public class Solution1974 {
    public static void main(String[] args) {
        Solution1974 obj = new Solution1974();
        System.out.println(obj.minTimeToType("abc"));
    }

    public int minTimeToType(String word) {
        int ans = 0;
        for (char c : word.toCharArray()) {
            int min = Math.min(c - 'a', 26 - c + 'a');
            ans += min + 1;
        }
        return ans;
    }
}
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
        for (int i = 0; i < word.length(); i++) {
            if (i == 0) {
                ans += Math.min(word.charAt(i) - 'a', 26 - word.charAt(i) + 'a') + 1;
            } else {
                ans += Math.min(word.charAt(i) - word.charAt(i - 1), 26 - word.charAt(i) + word.charAt(i - 1)) + 1;
            }
        }
        return ans;
    }
}
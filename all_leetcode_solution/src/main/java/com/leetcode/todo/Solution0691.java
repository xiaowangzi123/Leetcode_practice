package com.leetcode.todo;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/3/21
 * @description: TODO
 * 691. 贴纸拼词
 */
public class Solution0691 {
    public static void main(String[] args) {
        Solution0691 obj = new Solution0691();
        System.out.println(obj.minStickers(new String[]{"with", "example", "science"}, "thehat"));
        System.out.println(obj.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
    }

    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] memo = new int[1 << m];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int res = dp(stickers, target, memo, (1 << m) - 1);
        return res <= m ? res : -1;
    }

    public int dp(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            int res = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a']--;
                        left ^= 1 << i;
                    }
                }
                if (left < mask) {
                    res = Math.min(res, dp(stickers, target, memo, left) + 1);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }

}
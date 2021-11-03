package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/3
 * @description : 连续字符
 */
public class Solution1446 {
    public static void main(String[] args) {
        Solution1446 obj = new Solution1446();
        System.out.println(obj.maxPower("leetcode"));
    }

    public int maxPower(String s) {
        int ans = 0, count = 1;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/3
 * @description : 连续字符
 */
public class Solution1446 {
    public static void main(String[] args) {
        Solution1446 obj = new Solution1446();
//        System.out.println(obj.maxPower("leetcode"));
//        System.out.println(obj.maxPower("l"));
        System.out.println(obj.maxPower("aa"));
        System.out.println(obj.maxPower2("aa"));
        System.out.println(obj.maxPower2("ababababa"));
    }

    public int maxPower(String s) {
        int ans = 1, count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }

    //双指针
    public int maxPower2(String s) {
        int ans = 1, n = s.length();
        int i = 0, j = 1;
        while (j < n) {
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }

    /**
     * 滑动窗口
     */
    public int maxPower3(String s) {
        int ans = 1, n = s.length();
        int i = 0, j = 1;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            } else {
                i++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 替换隐藏数字得到的最晚时间
 */
public class Solution1736 {
    public static void main(String[] args) {
        Solution1736 obj = new Solution1736();
        System.out.println(obj.maximumTime("2?:?0"));
    }

    public String maximumTime(String time) {
        char[] ans = time.toCharArray();
        if (ans[0] == '?') {
            ans[0] = ('4' <= ans[1] && ans[1] <= '9') ? '1' : '2';
        }
        if (ans[1] == '?') {
            ans[1] = ans[0] == '2' ? '3' : '9';
        }
        if (ans[3] == '?') {
            ans[3] = '5';
        }
        if (ans[4] == '?') {
            ans[4] = '9';
        }

        return new String(ans);
    }
}
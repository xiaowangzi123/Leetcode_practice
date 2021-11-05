package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/5
 * @description : 替换所有的问号
 */
public class Solution1576 {
    public static void main(String[] args) {
        Solution1576 obj = new Solution1576();
        System.out.println(obj.modifyString("?"));
        System.out.println("-------------");
        System.out.println(obj.returnDiff('b', 'a'));
        System.out.println(obj.returnDiff(' ', 'a'));
    }

    public String modifyString(String s) {
        char[] ans = s.toCharArray();
        if (s.length() == 1 && ans[0] == '?') {
            return "a";
        }
        for (int i = 0; i < s.length(); i++) {
            if (ans[i] == '?') {
                if (i == 0) {
                    ans[i] = returnDiff(' ', ans[i + 1]);
                } else if (i == s.length() - 1) {
                    ans[i] = returnDiff(ans[i - 1], ' ');
                } else {
                    ans[i] = returnDiff(ans[i - 1], ans[i + 1]);
                }
            }
        }
        return new String(ans);
    }

    public char returnDiff(char a, char b) {
        char ans = 'a';
        while (ans == a || ans == b) {
            ans++;
        }
        return ans;
    }
}
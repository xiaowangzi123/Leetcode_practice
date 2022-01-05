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
        System.out.println(obj.modifyString2("?"));
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

    /**
     * 找出？前后的字母，找一个与前后两个字母不同的字母，赋值给？
     */
    public String modifyString2(String s) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (ans[i] == '?') {
                char a = (i == 0 ? ' ' : ans[i - 1]);
                char b = (i == n - 1 ? ' ' : ans[i + 1]);
                char temp = 'a';
                while (temp == a || temp == b) {
                    temp++;
                }
                ans[i] = temp;
            }
        }
        return new String(ans);
    }
}
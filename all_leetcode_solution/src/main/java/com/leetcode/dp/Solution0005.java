package com.leetcode.dp;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/22
 * @description ：最长回文子串
 */
public class Solution0005 {
    public static void main(String[] args) {
        Solution0005 obj = new Solution0005();
        String s = "abcbacaed";
        System.out.println(obj.longestPalindrome(s));
        System.out.println(obj.longestPalindrome2(s));
        System.out.println(obj.longestPalindrome3(s));
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        //回文子串的初始和结束索引
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数长度的子串
            int odd = palindromeLength(s, i, i);
            //偶数长度的子串
            int even = palindromeLength(s, i, i + 1);
            int len = Math.max(odd, even);
            //计算start和end值
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    //回文子串的个数或奇或偶，计算以某一个或两个元素为中心的回文子串的长度
    public int palindromeLength(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 动态规划
     * 首先定义 P(i，j）
     *       P(i,j)=true s[i,j]是回文串
     *       P(i,j)=false& s[i,j]不是回文串
     * 所以P(i,j)=(P(i+1,j−1)&&S[i]==S[j])
     * 我们首先知道了i +1才会知道 i,所以我们只需要倒着遍历就行了。
     *
     * 求 长度为 11 和长度为 22 的 P(i,j)P(i,j) 时不能用上边的公式
     */

    public String longestPalindrome2(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
        {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                {
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }

    public String longestPalindrome3(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome4(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
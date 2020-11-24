package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0647 {
    public static void main(String[] args) {
        Solution0647 obj = new Solution0647();
        String st = "aabbcc";
        System.out.println(obj.countSubstrings(st));
        System.out.println(obj.countSubstrings2(st));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) ++res;
            }
        }
        return res;
    }

    public int countSubstrings2(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


}
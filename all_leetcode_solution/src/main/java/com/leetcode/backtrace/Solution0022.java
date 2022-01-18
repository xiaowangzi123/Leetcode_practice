package com.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 组合
 */
public class Solution0022 {
    public static void main(String[] args) {
        Solution0022 obj = new Solution0022();
        System.out.println(obj.generateParenthesis(2));
    }

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return ans;
    }

    public void backtrack(int l, int r, int n, String s) {
        if (l == n && r == n) {
            ans.add(s);
            return;
        }
        if (l < r) {
            return;
        }
        if (l < n) {
            backtrack(l + 1, r, n, s + "(");
        }
        if (r < n) {
            backtrack(l, r + 1, n, s + ")");
        }

    }

}
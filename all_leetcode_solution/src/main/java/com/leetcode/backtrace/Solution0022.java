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
        System.out.println(obj.generateParenthesis(3));
    }

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return ans;
    }

    /**
     *
     */
    public void backtrack(int l, int r, StringBuilder sb) {
        if (l == 0 && r == 0) {
            ans.add(sb.toString());
            return;
        }

        if (l > 0) {
            backtrack(l - 1, r, sb.append("("));
        }

        if (r > 0) {
            backtrack(l, r - 1, sb.append(")"));
        }

    }

}
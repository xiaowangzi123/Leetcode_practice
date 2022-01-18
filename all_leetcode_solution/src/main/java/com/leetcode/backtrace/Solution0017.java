package com.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/26
 * @description :
 */
public class Solution0017 {
    public static void main(String[] args) {
        Solution0017 obj = new Solution0017();
        System.out.println(obj.letterCombinations("23"));
    }

    private String digLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        backtrack(0, n, new StringBuilder(), digits);
        return ans;
    }

    public void backtrack(int start, int n, StringBuilder path, String digits) {
        if (path.length() == n) {
            ans.add(path.toString());
            return;
        }
        char dig = digits.charAt(start);
        String digLet = digLetter[dig - '0'];
        for (int i = 0; i < digLet.length(); i++) {
            path.append(digits.charAt(i));
            backtrack(start + 1, n, path, digits);
            path.deleteCharAt(start);
        }
    }

}
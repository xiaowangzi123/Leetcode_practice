package com.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/26
 * @description : 电话号码的字母组合
 */
public class Solution0017 {
    public static void main(String[] args) {
        Solution0017 obj = new Solution0017();
//        System.out.println(obj.letterCombinations(""));
//        System.out.println(obj.letterCombinations("2"));
        System.out.println(obj.letterCombinations("23"));

        System.out.println("------------------");
        String s1 = "abc";
        System.out.println(s1.hashCode());
        String s2 = s1;
        System.out.println(s2.hashCode());
        s1 = "bcd";
        System.out.println(s1.hashCode());

        StringBuilder s3 = new StringBuilder("abc");
        System.out.println(s3.hashCode());
        s3.append("bcd");
        System.out.println(s3.hashCode());
    }

    private String digLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
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
            path.append(digLet.charAt(i));
            backtrack(start + 1, n, path, digits);
            path.deleteCharAt(start);
        }
    }


    /**
     * 可以使用String的不可变特性
     * 不用在回溯时，先添加元素，然后再删除
     * 这种方式比Stringbuilder慢
     */
    public void backtrack2(int start, int n, String path, String digits) {
        if (path.length() == n) {
            ans.add(path);
            return;
        }
        char dig = digits.charAt(start);
        String digLet = digLetter[dig - '0'];
        for (int i = 0; i < digLet.length(); i++) {
            backtrack2(start + 1, n, path + digLet.charAt(i), digits);
        }
    }

    /**
     * 每个数字代表的字符串都处于同一层级，for循环不合适
     */
    public List<String> letterCombinations2(String digits) {
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            char digt = digits.charAt(i);
            String ditLet = digLetter[digt-'0'];
        }
        return ans;
    }

}
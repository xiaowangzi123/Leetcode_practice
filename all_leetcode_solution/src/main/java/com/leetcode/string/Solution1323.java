package com.leetcode.string;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1323 {

    public static void main(String[] args) {
        Solution1323 obj = new Solution1323();
        String s = "RLRRLLRLRL";
        System.out.println(obj.balancedStringSplit(s));
    }


    public int balancedStringSplit(String s) {
        int result = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') ++count;
            else --count;
            if (count == 0) ++result;
        }
        return result;
    }


}
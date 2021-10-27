package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/26
 * @description : 旋转字符串
 */
public class Solution0796 {
    public static void main(String[] args) {
        Solution0796 obj = new Solution0796();
        String s = "abcde", goal = "bcdea";
        System.out.println(obj.rotateString(s, goal));
    }

    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (goal.length() != n) {
            return false;
        }
        int k = 0;
        while (k < n) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt((i + k) % n) != goal.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                return true;
            }
            k++;
        }
        return false;
    }
}
package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/3/7
 * @description: 七进制数
 */
public class Solution0504 {
    public static void main(String[] args) {
        Solution0504 obj = new Solution0504();
        System.out.println(obj.convertToBase7(0));
        System.out.println(obj.convertToBase7(100));
        System.out.println(obj.convertToBase7(-50));

        System.out.println(Integer.toString(0, 7));
        System.out.println(Integer.toString(100, 7));
        System.out.println(Integer.toString(-50, 7));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean positive = num > 0;
        if (!positive) {
            num = -num;
        }
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            ans.append(num % 7);
            num /= 7;
        }
        if (!positive) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }


}
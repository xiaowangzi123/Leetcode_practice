package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description :
 */
public class Solution0038 {
    public static void main(String[] args) {
        Solution0038 obj = new Solution0038();
        System.out.println(obj.countAndSay(1));
        System.out.println(obj.countAndSay(2));
        System.out.println(obj.countAndSay(3));
        System.out.println(obj.countAndSay(4));
        System.out.println(obj.countAndSay(5));
        System.out.println(obj.countAndSay(6));
    }


    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int index = 0;

            while (index < str.length()) {
                while (index < str.length() && str.charAt(index) == str.charAt(start)) {
                    index++;
                }
                sb.append(Integer.toString(index - start)).append(str.charAt(start));
                start = index;
            }
            str = sb.toString();
        }

        return str;
    }
}
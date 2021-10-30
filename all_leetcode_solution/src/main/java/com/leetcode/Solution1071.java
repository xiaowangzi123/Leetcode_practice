package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/30
 * @description : 字符串的最大公因子
 */
public class Solution1071 {
    public static void main(String[] args) {
        Solution1071 obj = new Solution1071();
//        String str1 = "ABCABC", str2 = "ABC";
        String str1 = "ABABAB", str2 = "ABAB";
        String ans = obj.gcdOfStrings(str1, str2);
        System.out.println(ans);
    }


    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        String temp = str1.substring(0, gongYueShu(len1, len2));
        if (check(temp, str1) && check(temp, str2)) {
            return temp;
        }
        return "";
    }

    public boolean check(String t, String s) {
        int len = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= len; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

    public String gcdOfStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int index = gongYueShu(str1.length(), str2.length());
        return str1.substring(0, index);
    }

    public int gongYueShu(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
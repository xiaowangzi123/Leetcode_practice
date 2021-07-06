package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0067 {
    public static void main(String[] args) {
        Solution0067 obj = new Solution0067();
        String a = "1010", b = "1011";
        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


}
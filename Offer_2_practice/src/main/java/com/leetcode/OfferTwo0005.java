package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 替换空格
 */
public class OfferTwo0005 {
    public static void main(String[] args) {
        OfferTwo0005 obj = new OfferTwo0005();
        System.out.println(obj.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        int index = 0, n = s.length();
        char[] ans = new char[n * 3];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                ans[index++]='%';
                ans[index++]='2';
                ans[index++]='0';
            } else {
                ans[index++] = s.charAt(i);
            }
        }
        return new String(ans, 0, index);
    }
}
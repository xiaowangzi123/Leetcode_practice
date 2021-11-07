package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 有效的回文
 * 和LeetCode0125一样
 * {@link  com.leetcode.Solution0125}
 */
public class OfferTwo0018 {
    public static void main(String[] args) {
        OfferTwo0018 obj = new OfferTwo0018();
        String s = "n, a plan, a canal: Pan";
//        System.out.println(obj.isPalindrome(s));
        System.out.println(obj.isPalindrome(".,"));
        System.out.println(obj.isPalindrome("0P"));
    }

    //还要考虑数字
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isLitter(s.charAt(i))) {
                i++;
            }
            while (i < j && !isLitter(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    public boolean isLitter(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

}
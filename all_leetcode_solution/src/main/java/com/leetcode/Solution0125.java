package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description：
 */
public class Solution0125 {
    public static void main(String[] args) {
        Solution0125 obj = new Solution0125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));


        StringBuffer s2 = new StringBuffer("man");
        System.out.println(s2.hashCode());
        System.out.println(s2.reverse().hashCode());
        //Stringbuffer没有重写equals方法，比较是地址，两者地址一样
        System.out.println(s2.equals(s2.reverse()));

        String s3 = "0P";
        System.out.println("0P:" + obj.isPalindrome(s3));

        System.out.println("0:" + Character.isLetter('0'));
        System.out.println(Character.isLetter(1));
    }

    public boolean isPalindrome(String s) {
        StringBuffer s1 = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.toLowerCase().charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                s1.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer s2 = new StringBuffer(s1).reverse();
        return s1.toString().equals(s2.toString());
    }
}
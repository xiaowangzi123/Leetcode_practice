package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0859 {
    public static void main(String[] args) {
        Solution0859 obj = new Solution0859();
        String A = "aaaaaaabc", B = "aaaaaaacb";
        System.out.println(obj.buddyStrings(A, B));

        System.out.println("---------------");

        System.out.println(A.replace('b', 'd'));
        System.out.println(A.replace('a', 'd'));

        System.out.println("---------------");
        StringBuilder s1 = new StringBuilder("ab");
        StringBuilder s2 = new StringBuilder("ba");
        StringBuilder s3 = new StringBuilder("ab");

        //false
        System.out.println(s1.equals(s3));
//        System.out.println(s1.toString().equals(s3.reverse().toString())); //false
        //true
//        System.out.println("ab".equals(s3.reverse().toString()));
//        System.out.println(s1.equals(s2.reverse()));//false
//        System.out.println(s1.toString().equals(s2.reverse().toString()));
//        if (s1.toString().equals(s2.reverse().toString())){
//            System.out.println("equals");
//        }
//        System.out.println("ab".equals(s2.reverse().toString()));
    }

    /**
     * 1.A、B字符串长度不同，直接返回false
     * 2.A等于B,找其中一个字符串是否有重复元素，有重复，返回true；没有重复元素，返回false
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                if (i != s.lastIndexOf(s.charAt(i))) {
                    return true;
                }
            }
            return false;
        } else {
            //把AB字符串对应位置不同的字符遍历取出
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    s1.append(s.charAt(i));
                    s2.append(goal.charAt(i));
                }
            }
            if (s1.length() != 2 || s2.length() != 2) {
                return false;
            }
            if (s1.toString().equals(s2.reverse().toString())) {
                return true;
            } else {
                return false;
            }
        }

    }


}
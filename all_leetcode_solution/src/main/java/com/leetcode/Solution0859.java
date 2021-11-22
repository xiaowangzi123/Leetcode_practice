package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description : 亲密字符串
 */
public class Solution0859 {
    public static void main(String[] args) {
        Solution0859 obj = new Solution0859();
        System.out.println(obj.buddyStrings("aaaaaaabc", "aaaaaaacb"));

        System.out.println("---------------");

        System.out.println("aaaaaaacb".replace('b', 'd'));
        System.out.println("aaaaaaacb".replace('a', 'd'));

        System.out.println("---------------");
        StringBuilder s1 = new StringBuilder("ab");
        StringBuilder s2 = new StringBuilder("ba");
        StringBuilder s3 = new StringBuilder("ab");
        StringBuilder s4 = new StringBuilder("ba");

        //StringBuilder没有重写equals方法，比较的是地址
        //false
        System.out.println(s1.equals(s3));
        //true
        System.out.println(s1.toString().equals(s3.toString()));
        //false
        System.out.println(s1.equals(s2.reverse()));
        //true
        System.out.println(s1.toString().equals(s4.reverse().toString()));
    }

    /**
     * 1.A、B字符串长度不同，直接返回false
     * 2.A等于B,找其中一个字符串是否有重复元素，有重复，返回true；没有重复元素，返回false
     * 3.A不等于B，找出AB对应位置不同的元素，组成S1，S2
     * 3.1.如果S1，S2的长度不等于2，无论怎么交换一次都无法满足条件，返回false
     * 3.1.S1，S2的长度等于2,对其中一个反转与另外一个相比，相等返回true；不相等返回false。
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
            return s1.toString().equals(s2.reverse().toString());
        }
    }


}
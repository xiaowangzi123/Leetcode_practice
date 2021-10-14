package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :仅执行一次字符串交换能否使两个字符串相等
 */
public class Solution1790 {
    public static void main(String[] args) {
        Solution1790 obj = new Solution1790();
//        String s1 = "bank", s2 = "kanb";
//        String s1 = "attack", s2 = "defend";
        String s1 = "qgqeg", s2 = "gqgeq";
//        String s1 = "abba", s2 = "baab";
        System.out.println(obj.areAlmostEqual(s1, s2));
        System.out.println("-----------------------------");

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        set1.add('b');
        set1.add('a');
        set2.add('a');
        set2.add('b');
        System.out.println(set1.equals(set2));
        System.out.println("----------------");
        System.out.println(set1.add('c'));
    }


    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!set1.add(s1.charAt(i)) || !set2.add(s2.charAt(i))){
                    return false;
                }
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
            }
        }
        if (set1.size() != 2 || set2.size() != 2) {
            return false;
        }
        return set1.equals(set2);
    }
}
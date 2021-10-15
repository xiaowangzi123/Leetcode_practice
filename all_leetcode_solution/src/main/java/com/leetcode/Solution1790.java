package com.leetcode;

import sun.awt.dnd.SunDragSourceContextPeer;

import java.util.*;

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
        System.out.println(obj.areAlmostEqual2(s1, s2));
        System.out.println("-----------------------------");

        List<String> l1 = new LinkedList<>();
        List<String> l2 = new LinkedList<>();
        l1.add("a");
        l1.add("b");
        l2.add("b");
        l2.add("a");
        System.out.println(l1.equals(l2));
        System.out.println(l1.remove(l2.get(0)));
        System.out.println(l1.remove(l2.get(1)));
        System.out.println(l1.size());
    }


    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!set1.add(s1.charAt(i)) || !set2.add(s2.charAt(i))) {
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

    public boolean areAlmostEqual2(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                l1.add(s1.charAt(i));
                l2.add(s2.charAt(i));
            }
        }
        if (l1.size() != 2 || l2.size() != 2) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (!l2.remove(l1.get(i))) {
                return false;
            }
        }
        return l2.size() == 0;
    }
}
package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :字符串中第二大的数字
 */
public class Solution1796 {
    public static void main(String[] args) {
        Solution1796 obj = new Solution1796();
        System.out.println(obj.secondHighest("dfa12321afd"));
        System.out.println(obj.secondHighest2("dfa12321afd"));
        System.out.println("-----------------------------");
        System.out.println(obj.secondHighest("abc1111"));
        System.out.println(obj.secondHighest2("abc1111"));

    }

    //set集合去除了重复数据，这样写不正确
    public int secondHighest(String s) {
        int first = -1, second = -1;
        Set<Integer> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                set.add(ch - '0');
            }
        }

        for (int i : set) {
            if (first < i) {
                second = first;
                first = i;
            } else if (second < i) {
                second = i;
            }
        }
        return second;
    }

    //有重复数据，改进方法如下
    public int secondHighest2(String s) {
        int first = -1, second = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int temp = ch - '0';
                if (first < temp) {
                    second = first;
                    first = temp;
                } else if (second < temp) {
                    second = temp;
                }
            }
        }
        return second;
    }

    public int secondHighest3(String s) {
        int first = -1, second = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int temp = ch - '0';
                if (first == -1) {
                    first = temp;
                } else if (first < temp) {
                    second = first;
                    first = temp;
                } else if (second < temp && temp < first) {
                    second = temp;
                }
            }
        }
        return second;
    }
}
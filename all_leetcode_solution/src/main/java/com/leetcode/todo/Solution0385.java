package com.leetcode.todo;

/**
 * @author :wyq
 * @date ：Created in 2022/4/15
 * @description : TODO
 *
 * 385. 迷你语法分析器
 */
public class Solution0385 {
    public static void main(String[] args) {

    }

    int index = 0;

    /*public NestedInteger deserialize(String s) {
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return ni;
        } else {
            boolean negative = false;
            if (s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            if (negative) {
                num *= -1;
            }
            return new NestedInteger(num);
        }
    }*/
}
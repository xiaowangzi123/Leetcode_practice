package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :棒球比赛
 */
public class Solution0682 {
    public static void main(String[] args) {
        Solution0682 obj = new Solution0682();
        String[] st = {"5", "2", "C", "D", "+"};
        System.out.println(obj.calPoints(st));
    }

    public int calPoints(String[] ops) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String st : ops) {
            switch (st) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    int n1 = stack.peekFirst();
                    stack.push(n1 * 2);
                    break;
                case "+":
                    int t1 = stack.pop();
                    int t2 = t1 + stack.peekFirst();
                    stack.push(t1);
                    stack.push(t2);
                    break;
                default:
                    stack.push(Integer.valueOf(st));
            }
        }

        for (int s : stack) {
            sum += s;
        }
        return sum;
    }
}
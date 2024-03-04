package com.leetcode.s0201_0300;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 */
public class Solution0232 {
    public static void main(String[] args) {
        Solution0232 obj = new Solution0232();



    }

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public Solution0232() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}
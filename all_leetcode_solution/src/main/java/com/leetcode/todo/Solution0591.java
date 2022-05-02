package com.leetcode.todo;

import java.util.Stack;

/**
 * @author :wyq
 * @date ：Created in 2022/5/2
 * @description :TODO
 * 591. 标签验证器
 */
public class Solution0591 {
    public static void main(String[] args) {

    }

    /**
     * 栈记录及匹配标签
     * 每次扫描到一个 '<' 字符时
     * 如果后面跟着的是 '!' 字符, 期望后面是 "[CDATA[", 如果不是返回 false, 然后直到 "]]>" 前的字符都不需要解析, 如果找不到 "]]>” 字符, 返回 false
     * 如果后面跟着的是 '/' 字符, 说明这是结束标签, 比较栈中标签是否匹配, 弹出元素前后都要判断一次栈空
     * 标签中的字符均不需要解析
     */
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int n = code.length(), i = 0, j = 0;
        if (n < 7) {
            return false;
        }
        while (i < n) {
            if (code.charAt(i) != '<') {
                if (stack.empty()) return false;
                ++i;
                continue;
            }
            char c = code.charAt(i + 1);
            if (c == '!') {
                if (stack.empty()) {
                    return false;
                }
                if (!code.startsWith("[CDATA[", i + 2)) {
                    return false;
                }
                j = code.indexOf("]]>", i + 9);
                if (j == -1) {
                    return false;
                }
                i = j + 3;
            } else if (c == '/') {
                if (stack.empty()) {
                    return false;
                }
                j = code.indexOf('>', i + 2);
                if (j == -1 || j == i + 2 || j > i + 11) {
                    return false;
                }
                if (!code.substring(i + 2, j).equals(stack.pop())) {
                    return false;
                }
                i = j + 1;
                if (stack.empty()) {
                    return i == n;
                }
            } else {
                j = code.indexOf('>', i + 1);
                if (j == -1 || j == i + 1 || j > i + 10) {
                    return false;
                }
                for (int k = i + 1; k < j; k++) {
                    if (code.charAt(k) < 'A' || code.charAt(k) > 'Z') {
                        return false;
                    }
                }
                stack.push(code.substring(i + 1, j));
                i = j + 1;
            }
        }
        return false;
    }

}
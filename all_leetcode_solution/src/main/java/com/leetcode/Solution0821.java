package com.leetcode;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.awt.*;
import java.awt.event.MouseWheelListener;
import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description : 字符的最短距离
 */
public class Solution0821 {
    public static void main(String[] args) {
        Solution0821 obj = new Solution0821();
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(obj.shortestToChar(s, c)));
        System.out.println("-------------------------");
        System.out.println(s.substring(0, 0).indexOf(c));
        System.out.println("love".lastIndexOf(c));
    }

    //由中间向两边遍历
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
            } else {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, n);
                int index1 = s1.lastIndexOf(c);
                int index2 = s2.indexOf(c);
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if (index1 != -1) {
                    a = s1.length() - index1;
                }
                if (index2 != -1) {
                    b = index2;
                }
                ans[i] = Math.min(a, b);
            }
        }
        return ans;
    }
}
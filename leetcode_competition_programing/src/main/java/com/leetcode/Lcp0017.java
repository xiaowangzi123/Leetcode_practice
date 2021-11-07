package com.leetcode;

/**
 * Hello world!
 */
public class Lcp0017 {
    public static void main(String[] args) {
        Lcp0017 obj = new Lcp0017();
        System.out.println(obj.calculate("AB"));
    }

    public int calculate(String s) {
        int x = 1, y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }
}

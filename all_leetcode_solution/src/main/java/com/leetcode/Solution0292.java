package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0292 {
    public static void main(String[] args) {
        Solution0292 obj = new Solution0292();
        System.out.println(obj.canWinNim(5));
    }
    /**
     * n=1,拿走一块，赢
     * n=2,拿走两块，赢
     * n=3，拿走三块，赢
     * n=4，无论拿走几块，对方都可以拿完，输
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
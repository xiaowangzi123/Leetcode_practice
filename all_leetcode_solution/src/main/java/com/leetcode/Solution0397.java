package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/19
 * @description : 整数替换
 */
public class Solution0397 {
    public static void main(String[] args) {
        Solution0397 obj = new Solution0397();
        System.out.println(obj.integerReplacement(7));
        System.out.println(obj.integerReplacement(8));
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2 + 1), integerReplacement(n / 2));
    }

    public int integerReplacement2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            return 0;
        }
        if (!map.containsKey(n)) {
            if (n % 2 == 0) {
                map.put(n, 1 + integerReplacement2(n / 2));
            } else {
                map.put(n, 2 + Math.min(integerReplacement2(n / 2 + 1), integerReplacement2(n / 2)));
            }
        }
        return map.get(n);
    }
}
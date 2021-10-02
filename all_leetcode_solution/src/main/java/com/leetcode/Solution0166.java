package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/3
 * @description :
 * -1
 * -2147483648
 */
public class Solution0166 {
    public static void main(String[] args) {
        Solution0166 obj = new Solution0166();
        System.out.println(obj.fractionToDecimal(2, 3));
        System.out.println(obj.fractionToDecimal(2, 5));
        System.out.println(obj.fractionToDecimal(7, -12));

        int numerator = -1, denominator = -2147483648;
        System.out.println(numerator / denominator < 0); //false
        System.out.println(denominator / numerator < 0); //true
        System.out.println(numerator / denominator < 0 || denominator / numerator < 0); //true
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        //整数部分
        sb.append(a / b);
        //没有余数，直接返回整数部分
        if (a % b == 0) {
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0) {
            return sb.toString();
        }
        return sb.insert(map.get(a).intValue(), '(').append(')').toString();
    }
}
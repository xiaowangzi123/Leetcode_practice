package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyq
 * @create time: 2021/12/31
 * @description: 完美数
 */
public class Solution0507 {
    public static void main(String[] args) {
        Solution0507 obj = new Solution0507();
        System.out.println(obj.checkPerfectNumber(1));
        System.out.println(obj.checkPerfectNumber(6));
        System.out.println(obj.checkPerfectNumber(28));
        System.out.println(obj.checkPerfectNumber(496));
        System.out.println(obj.checkPerfectNumber(8128));
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i < num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

}
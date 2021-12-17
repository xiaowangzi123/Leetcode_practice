package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyq
 * @create time: 2021/12/17
 * @description: 换酒问题
 */
public class Solution1518 {
    public static void main(String[] args) {
        Solution1518 obj = new Solution1518();
        System.out.println(obj.numWaterBottles(9, 3));
        System.out.println(obj.numWaterBottles(15, 4));
        System.out.println(obj.numWaterBottles(5, 5));
        System.out.println(obj.numWaterBottles(2, 3));
    }


    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles, empty = numBottles;
        while (empty >= numExchange) {
            empty = empty / numExchange + empty % numExchange;
            numBottles = empty / numExchange;
            ans += numBottles;
        }
        return ans;
    }
}
package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/15
 * @description : 灯泡开关
 */
public class Solution0319 {
    public static void main(String[] args) {
        Solution0319 obj = new Solution0319();
        System.out.println(obj.bulbSwitch(0));
        System.out.println(obj.bulbSwitch(3));
    }

    /**
     * @author: wyq
     * @create time: 2021/11/15
     * @description: TODO
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    public int bulbSwitch2(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        return count;
    }
}
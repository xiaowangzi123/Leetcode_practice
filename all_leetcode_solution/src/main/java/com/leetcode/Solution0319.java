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
     * 灯泡编号1,2，……n，默认全关闭
     * 可以理解为第i轮对编号为i的灯泡开关进行一次切换操作
     * 如果i有偶数个因数，那么最终灯泡关闭
     * 如果i有奇数个因数，那么灯泡最终打开
     *
     * 只有i为完全平方数的时候，灯泡最终是打开的
     * 所以寻找n个数中的完全平方数即为答案
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
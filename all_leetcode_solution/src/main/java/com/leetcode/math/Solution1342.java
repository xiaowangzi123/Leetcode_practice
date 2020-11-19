package com.leetcode.math;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1342 {

    public static void main(String[] args) {
        Solution1342 obj = new Solution1342();
        int a = 14;
        System.out.println(obj.numberOfSteps(a));
    }


    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
                count++;
            } else {
                num = num - 1;
                count++;
            }
        }
        return count;
    }


}
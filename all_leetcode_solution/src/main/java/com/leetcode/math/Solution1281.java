package com.leetcode.math;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1281 {

    public static void main(String[] args) {
        Solution1281 obj = new Solution1281();
        int a = 234;
        System.out.println(obj.subtractProductAndSum(a));
    }


    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        for (; n > 0; n /= 10) {
            product *= n % 10;
            sum += n % 10;
        }
        return product - sum;
    }


}
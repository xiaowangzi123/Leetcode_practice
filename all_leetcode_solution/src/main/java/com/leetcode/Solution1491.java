package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 去掉最低工资和最高工资后的工资平均值
 */
public class Solution1491 {
    public static void main(String[] args) {
        Solution1491 obj = new Solution1491();
//        int[] arr = {4000, 3000, 1000, 2000};
        int[] arr = {48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000};
        System.out.println(obj.average(arr));
        System.out.println(obj.average2(arr));

    }

    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0, n = salary.length;
        for (int i = 1; i < n - 1; i++) {
            sum += salary[i];
        }
        return (double) sum / (n - 2);
    }

    public double average2(int[] salary) {
        int sum = 0, n = salary.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        return (double) (sum - min - max) / (n - 2);
    }
}
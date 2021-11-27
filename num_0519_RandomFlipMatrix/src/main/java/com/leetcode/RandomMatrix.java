package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2021/11/27
 * @description: 随机翻转矩阵
 */
public class RandomMatrix {
    public static void main(String[] args) {
        RandomMatrix obj = new RandomMatrix(3, 1);
        System.out.println(Arrays.toString(obj.flip()));
        System.out.println(Arrays.toString(obj.flip()));
        System.out.println(Arrays.toString(obj.flip()));
        obj.reset();

    }

    int m, n;
    Set<Integer> set;

    public RandomMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        set = new HashSet<>();
    }

    public int[] flip() {
        while (true) {
            int a = (int) (m * n * Math.random());
            if (!set.contains(a)) {
                set.add(a);
                return new int[]{a / n, a % n};
            }
        }
    }

    public void reset() {
        set = new HashSet<>();
    }
}
